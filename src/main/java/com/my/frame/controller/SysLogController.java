package com.my.frame.controller;

import com.github.pagehelper.PageInfo;
import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysLog;
import com.my.frame.model.querymodel.SysLogQueryModel;
import com.my.frame.service.SysLogService ;
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
@RequestMapping("/sysLog*")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 进入页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "sysLog/manager";
    }

    /**
     * 分页记录
     * @param sysLogQueryModel
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "pageSysLog")
    @ResponseBody
    public ListViewModel<SysLog> getPageSysLog(
            SysLogQueryModel sysLogQueryModel,
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
        PageInfo<SysLog> sysLogPageInfo = sysLogService.findPageInfo(property, value, searchType, sysLogQueryModel.getOrder(), SysLog.class, sysLogQueryModel.getPageNumber(), sysLogQueryModel.getPageSize());

        //返回结果
        return new ListViewModel(ListViewModel.CodeEnum.NORMAL.getValue(), sysLogPageInfo.getTotal(), sysLogPageInfo.getList());
    }


    /**
     * 单条信息
     * @param logId
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "getSysLog")
    @ResponseBody
    public ResultViewModel getSysLog(
            @RequestParam(value = "logId", required = true) String logId,
            HttpServletRequest request
    ){
        //查询记录
        SysLog sysLog = sysLogService.getByUniqueKey("logId", logId, SysLog.class);

        //返回结果
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", sysLog);
    }

    /**
     * 增加
     * @param sysLog        新增的信息
     * @return
     */
    @RequestMapping(value = "createSysLog", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createSysLog(
            SysLog sysLog,
            HttpServletRequest request
    ){
        return saveSysLog(sysLog, request);
    }

    /**
     * 修改
     * @param sysLog        修改的信息
     * @return
     */
    @RequestMapping(value = "updateSysLog", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateSysLog(
            SysLog sysLog,
            HttpServletRequest request
    ){
        return saveSysLog(sysLog, request);
    }

    /**
     * 增改
     * @param sysLog        保存的信息
     * @return
     */
    private ResultViewModel saveSysLog(
            SysLog sysLog,
            HttpServletRequest request
    ){

        /**
         * TODO 设置页面中没有的额外信息
         */

        //修改
        if(sysLog.getLogId() != null){
            //修改节点信息
            sysLogService.updateByPrimaryKeySelective(sysLog);
        }
        //新增
        else{
            //保存节点信息
            sysLogService.save(sysLog);
        }

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }



    /**
     * 删除一条【物理删除】
     * @param logId
     * @param request
     * @return
     */
     @RequestMapping(value = "deleteSysLog_physics", method = RequestMethod.GET)
     @ResponseBody
     public ResultViewModel deleteSysLog_physics(
             @RequestParam(value = "logId", required = true) String logId,
             HttpServletRequest request
     ){
        //先获取到要删除的记录
        SysLog sysLog = (SysLog)getSysLog(logId, request).getData();
        //删除本条记录
        sysLogService.delete(sysLog);

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
     }
}
