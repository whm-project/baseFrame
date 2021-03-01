package com.my.frame.controller;

import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.commonEnum.StatusEnum;
import com.my.frame.model.SysOrg;
import com.my.frame.service.SysOrgService;
import com.my.utils.StringUtil;
import com.my.utils.UUIDUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author
 * @version 0.0.1
 * @date 2018/07/27
 * @time 10:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysOrg*")
public class SysOrgController {

    @Autowired
    private SysOrgService sysOrgService;

    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "org/orgManager";
    }

    /**
     * 获取组织机构信息
     * @param orgCd    组织机构编码
     * @param request
     * @return
     */
    @RequestMapping(value = "getOrgInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultViewModel getOrgInfo(
            @RequestParam(value = "orgCd", defaultValue = "", required = false) String orgCd,
            HttpServletRequest request
    ){
        if(orgCd.equals("")){
            orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        }
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", sysOrgService.getByUniqueKey("orgCd", orgCd, SysOrg.class));
    }

    /**
     * 获取子节点
     * @param pcd           父级节点编码
     * @param ignoreCd      忽略不显示的组织机构编码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getChildOrg", method = RequestMethod.POST)
    @ResponseBody
    public List<SysOrg> getChild(
            @RequestParam(value = "pcd", required = false, defaultValue = "") String pcd,
            @RequestParam(value = "ignoreCd", required = false, defaultValue = "") String ignoreCd,
            HttpServletRequest request, HttpServletResponse response
    ){
        List<SysOrg> sysOrgList = new ArrayList<>();
        //如果组织机构选择为空，默认为当前用户所属的组织机构
        if (pcd.equals("")){
            String userOrgCd = StringUtil.notNull(request.getSession().getAttribute("userOrgCd"));
            sysOrgList.add(sysOrgService.getByUniqueKey("orgCd", userOrgCd, SysOrg.class));
        }
        else{
            //条件集合
            List<String> property = new ArrayList<>();
            List<Object> value = new ArrayList<>();
            List<String> searchType = new ArrayList<>();

            //上级组织机构条件
            property.add("engManCd");
            value.add(pcd);
            searchType.add(SearchTypeEnum.EQ.getValue());

            //组织机构状态条件
            property.add("orgStatus");
            value.add(StatusEnum.DELETED.getValue());
            searchType.add(SearchTypeEnum.NQ.getValue());

            //忽略的组织机构
            if(!ignoreCd.equals("")){
                property.add("orgCd");
                value.add(ignoreCd);
                searchType.add(SearchTypeEnum.NOTLIKE.getValue());
            }

            //排序
            String order = " orgStatus desc, orgOrder asc, ts desc ";
            //查询
            sysOrgList = sysOrgService.findInfo(property, value, searchType, order, SysOrg.class);
        }

        //返回数据
        return sysOrgList;
    }

    /**
     * 启用组织机构
     * @param orgCd     要启用的组织机构编码
     * @return
     */
    @RequestMapping(value = "useOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResultViewModel useOrg(
            @RequestParam(value = "orgCd", required = true) String orgCd
    ){
        SysOrg sysOrg = new SysOrg();
        sysOrg.setOrgCd(orgCd);
        sysOrg.setOrgStatus(StatusEnum.USED.getValue());
        sysOrg.setTs(new Date());
        sysOrgService.updateInfoSelective(sysOrg, "orgCd", orgCd, SearchTypeEnum.EQ.getValue(), SysOrg.class);
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 停用组织机构
     * @param orgCd     要停用的组织机构编码
     * @return
     */
    @RequestMapping(value = "stopOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResultViewModel stopOrg(
            @RequestParam(value = "orgCd", required = true) String orgCd
    ){
        SysOrg sysOrg = new SysOrg();
        sysOrg.setOrgStatus(StatusEnum.NOUSED.getValue());
        sysOrg.setTs(new Date());
        sysOrgService.updateInfoSelective(sysOrg, "orgIndex", "%"+orgCd+"%", SearchTypeEnum.LIKE.getValue(), SysOrg.class);
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 删除组织机构
     * @param orgCd     要删除的组织机构编码
     * @return
     */
    @RequestMapping(value = "delOrg", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel delOrg(
            @RequestParam(value = "orgCd", required = true) String orgCd
    ){
        //节点信息
        SysOrg org = sysOrgService.getByUniqueKey("orgCd", orgCd, SysOrg.class);
        //上级节点
        String eng_man = org.getEngManCd();

        //删除节点
        SysOrg sysOrg = new SysOrg();
        sysOrg.setOrgCd(orgCd);
        sysOrg.setOrgStatus(StatusEnum.DELETED.getValue());
        sysOrg.setTs(new Date());
        sysOrgService.deleteByProperty("orgIndex", "%"+orgCd+"%", SearchTypeEnum.LIKE.getValue(), SysOrg.class);

        //设置父级组织机构的isParent属性
        sysOrgService.setOrgIsParent(eng_man);

        //返回
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 验证组织机构code唯一性
     * @param orgCd             要检查的组织机构编码
     * @param orgId             当前组织机构序号
     * @return
     */
    @RequestMapping(value = "checkOrgCd", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel checkOrgCd(
            @RequestParam(value = "orgCd", required = true) String orgCd,
            @RequestParam(value = "orgId", required = false, defaultValue = "") String orgId){
        SysOrg org = sysOrgService.getByUniqueKey("orgCd", orgCd, SysOrg.class);
        //有这个code的记录
        if(org != null){
            //判断是不是当前记录
            Long org_id = org.getOrgId();
            //是当前记录，返回可用
            if(org_id.equals(orgId)){
                return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
            }
            //不是当前记录，返回不可用
            else{
                return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "该代码已存在，请检查！");
            }
        }
        //没有这个code的记录，则返回成功
        else{
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
        }
    }

    /**
     * 增加组织机构
     * @param sysOrg        新增的组织机构信息
     * @return
     */
    @RequestMapping(value = "createOrg", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createOrg(SysOrg sysOrg){
        return saveOrg(sysOrg);
    }

    /**
     * 修改组织机构
     * @param sysOrg        修改的组织机构信息
     * @return
     */
    @RequestMapping(value = "updateOrg", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateOrg(SysOrg sysOrg){
        return saveOrg(sysOrg);
    }

    /**
     * 增改组织机构
     * @param sysOrg        保存的组织机构信息
     * @return
     */
    private ResultViewModel saveOrg(SysOrg sysOrg){
        String new_eng_man_cd = StringUtil.notNull(sysOrg.getEngManCd());

        //设置索引index
        try {
            SysOrg eng_man = sysOrgService.getByUniqueKey("orgCd", new_eng_man_cd, SysOrg.class);
            String eng_man_index = StringUtil.notNull(eng_man.getOrgIndex());
            sysOrg.setOrgIndex(eng_man_index+"_"+sysOrg.getOrgCd());
        }catch (Exception e){
            e.printStackTrace();
        }

        //更新或修改
        if(sysOrg.getOrgId() != null){
            Map<String, Object> resultMap = sysOrgService.updateSysOrg(sysOrg);

            //返回原父节点cd和新父节点cd
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", resultMap);
        }else{
            //保存节点信息
            sysOrgService.save(sysOrg);

            //设置父级是否有子节点
            sysOrgService.setOrgIsParent(new_eng_man_cd);

            //返回新节点信息
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", JSONObject.fromObject(sysOrg).toString());
        }

    }

}
