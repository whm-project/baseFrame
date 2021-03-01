package com.my.frame.controller;

import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysImg;
import com.my.frame.service.SysImgService;
import com.my.utils.StringUtil;
import com.my.utils.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author
 * @version 0.0.1
 * @date 2019/03/16
 * @time 15:21
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysImg*")
public class SysImgController {

    @Autowired
    private SysImgService sysImgService;

    /**
     * 进入图片管理页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String img(){
        return "img/img_manager";
    }

    /**
     * 获取图片，根据图片类型
     * @param imgType       图片类型
     * @return 选择进入单选或多选
     */
    @RequestMapping(value = "showImg", method = RequestMethod.GET)
    @ResponseBody
    public ListViewModel<SysImg> showImg(
            @RequestParam(name = "imgType", required = false, defaultValue = "") String imgType
    ){
        List<SysImg> imgList = new ArrayList<>();
        if(!imgType.equals("")){
            imgList = sysImgService.findInfo("imgType", (Object)imgType, SearchTypeEnum.EQ.getValue(), "img_id desc", SysImg.class);
        }else{
            imgList = sysImgService.findAll();
        }

        return new ListViewModel<SysImg>(ListViewModel.CodeEnum.NORMAL.getValue(), imgList.size(), imgList);
    }

    /**
     * 新增图片
     * @param sysImg    图片信息
     * @param imgFile   图片
     * @return
     */
    @RequestMapping(value = "saveImg", method = RequestMethod.POST)
    @ResponseBody
    public ResultViewModel saveImg(
            SysImg sysImg,
            @RequestParam(name = "img", required = true) MultipartFile imgFile,
            HttpServletRequest request
    ){
        //图片所属组织机构
        String orgCd = StringUtil.notNull(sysImg.getOrgCd());
        if(orgCd.equals("")){
            orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        }

        //图片所属类型
        String imgType = StringUtil.notNull(sysImg.getImgType());
        if(imgType.equals("")){
            sysImg.setImgType(1);
        }

        //保存图片
        ResultViewModel resultViewModel = UploadUtil.uploadPicture(orgCd, sysImg.getImgType(), imgFile, request);

        //保存数据库记录
        sysImg.setOrgCd(orgCd);
        sysImg.setImgUrl(StringUtil.notNull(resultViewModel.getData()));
        sysImgService.save(sysImg);

        //返回
        return resultViewModel;
    }

}
