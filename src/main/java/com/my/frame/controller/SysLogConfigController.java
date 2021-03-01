package com.my.frame.controller;

import com.github.pagehelper.PageInfo;
import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysLogConfig;
import com.my.frame.model.querymodel.SysLogConfigQueryModel;
import com.my.frame.service.SysLogConfigService ;
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
import java.util.*;


/**
 * @author
 * @version 0.0.1
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysLogConfig*")
public class SysLogConfigController {

    @Autowired
    private SysLogConfigService sysLogConfigService;

    /**
     * 进入页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "sysLogConfig/manager";
    }

    /**
     * 分页记录
     * @param sysLogConfigQueryModel
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "pageSysLogConfig")
    @ResponseBody
    public ListViewModel<SysLogConfig> getPageSysLogConfig(
            SysLogConfigQueryModel sysLogConfigQueryModel,
            HttpServletRequest request
    ){
        //条件集合
        List<String> property = new ArrayList<>();
        List<Object> value = new ArrayList<>();
        List<String> searchType = new ArrayList<>();

        /**
         * TODO 添加查询条件设置
         */

        //进行查询
        PageInfo<SysLogConfig> sysLogConfigPageInfo = sysLogConfigService.findPageInfo(property, value, searchType, sysLogConfigQueryModel.getOrder(), SysLogConfig.class, sysLogConfigQueryModel.getPageNumber(), sysLogConfigQueryModel.getPageSize());

        //返回结果
        return new ListViewModel(ListViewModel.CodeEnum.NORMAL.getValue(), sysLogConfigPageInfo.getTotal(), sysLogConfigPageInfo.getList());
    }


    /**
     * 单条信息
     * @param logId
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "getSysLogConfig")
    @ResponseBody
    public ResultViewModel getSysLogConfig(
            @RequestParam(value = "logId", required = true) String logId,
            HttpServletRequest request
    ){
        //查询记录
        SysLogConfig sysLogConfig = sysLogConfigService.getByUniqueKey("logId", logId, SysLogConfig.class);

        //返回结果
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", sysLogConfig);
    }

    /**
     * 增加
     * @param sysLogConfig        新增的信息
     * @return
     */
    @RequestMapping(value = "createSysLogConfig", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createSysLogConfig(
            SysLogConfig sysLogConfig,
            HttpServletRequest request
    ){
        return saveSysLogConfig(sysLogConfig, request);
    }

    /**
     * 修改
     * @param sysLogConfig        修改的信息
     * @return
     */
    @RequestMapping(value = "updateSysLogConfig", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateSysLogConfig(
            SysLogConfig sysLogConfig,
            HttpServletRequest request
    ){
        return saveSysLogConfig(sysLogConfig, request);
    }

    /**
     * 增改
     * @param sysLogConfig        保存的信息
     * @return
     */
    private ResultViewModel saveSysLogConfig(
            SysLogConfig sysLogConfig,
            HttpServletRequest request
    ){

        /**
         * TODO 设置页面中没有的额外信息
         */

        //修改
        if(sysLogConfig.getLogId() != null){
            //修改节点信息
            sysLogConfigService.updateByPrimaryKeySelective(sysLogConfig);
        }
        //新增
        else{
            //保存节点信息
            sysLogConfigService.save(sysLogConfig);
        }

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }



    /**
     * 删除一条【物理删除】
     * @param logId
     * @param request
     * @return
     */
     @RequestMapping(value = "deleteSysLogConfig_physics", method = RequestMethod.GET)
     @ResponseBody
     public ResultViewModel deleteSysLogConfig_physics(
             @RequestParam(value = "logId", required = true) String logId,
             HttpServletRequest request
     ){
        //先获取到要删除的记录
        SysLogConfig sysLogConfig = (SysLogConfig)getSysLogConfig(logId, request).getData();
        //删除本条记录
        sysLogConfigService.delete(sysLogConfig);

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
     }
}
