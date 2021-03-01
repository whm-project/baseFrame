package com.my.filter;

import com.my.commonEnum.ModelEnum;
import com.my.commonEnum.OperationEnum;
import com.my.frame.model.SysLog;
import com.my.frame.model.SysLogConfig;
import com.my.frame.service.SysLogConfigService;
import com.my.frame.service.SysLogService;
import com.my.utils.StringUtil;
import com.my.utils.UUIDUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志拦截器切面
 *
 * @author Administrator
 */
@Component
@Aspect
public class LogAspect {
    @Autowired
    private SysLogConfigService sysLogConfigService;
    @Autowired
    private SysLogService sysLogService;


    @Around(value = "@annotation(com.my.filter.LogAnnotation )")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取抽象方法
        Signature signature = joinPoint.getSignature();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取目标对象上的Method对象
        Method targetMethod = methodSignature.getMethod();
        //TODO 日志，现在有问题 注解
        LogAnnotation logAnnotation = targetMethod.getAnnotation(LogAnnotation.class);
        if (logAnnotation == null) {
            return null;
        }

        //模块
        ModelEnum modelEnum = logAnnotation.model();
        //类型
        OperationEnum operationEnum = logAnnotation.operation();
        //查询库里是否有这个日志的配置信息
        SysLogConfig sysLogConfig = sysLogConfigService.getByUnionUniqueKey(
                new String[]{"modelName", "operType"},
                new String[]{modelEnum.getName(), operationEnum.getDescript()},
                SysLogConfig.class
        );
        //如果存在此配置信息并且需要记录
        if (sysLogConfig != null && "1".equals(sysLogConfig.getFlag())) {
            saveLog("【通知类型：前置通知】【请求状态：成功】", modelEnum, operationEnum);
            try {
                Object objectResult = joinPoint.proceed();
                saveLog("【通知类型：后置通知】【响应状态：成功】", modelEnum, operationEnum);
                return objectResult;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                saveLog("【通知类型：后置通知】【响应状态：失败】【失败信息：" + throwable + "】", modelEnum, operationEnum);
                return null;
            }
        }
        //如果不存在日志配置信息，往库里添加配置信息
        if (sysLogConfig == null) {
            SysLogConfig logConfig = SysLogConfig.set(UUIDUtil.getUUIDStr(), modelEnum.getName(), operationEnum.getDescript(), "0", new Date());
            sysLogConfigService.save(logConfig);
        }
        return joinPoint.proceed();
    }

    //保存日志
    private void saveLog(String notice, ModelEnum modelEnum, OperationEnum operationEnum) {
        try{
            //获取request的参数并保存日志
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            if(session != null){
                String userCd = (String) session.getAttribute("userCd");
                String userNm = (String) session.getAttribute("userNm");
                String ts = "【请求地址：" + StringUtil.getRequestIp(request) + "】【请求参数：" + StringUtil.getRequestParamsVal(request) + "】";
                SysLog log = SysLog.set(System.currentTimeMillis() + "", new Date(), operationEnum.getDescript(), userCd, userNm, modelEnum.getName(), null, notice + ts);
                sysLogService.save(log);
            }
        }catch (Exception e){

        }
    }


}