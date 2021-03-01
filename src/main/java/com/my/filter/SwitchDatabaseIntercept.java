package com.my.filter;

import com.my.utils.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 动态切换数据源：数据源名和包名一致
 * @author whm
 * @date 2019/11/14
 */
@Component
@Aspect
@Order(1)
public class SwitchDatabaseIntercept{

    private final int databaseIndex = 7;

    /**
     * 操作之前切换数据源
     * @param joinPoint
     */
    @Before("execution(* com.my..*Service..*(..))")
    public void doSwitchDatabase(JoinPoint joinPoint){
        //获取目标对象的类类型
        Class<?> pointClass = joinPoint.getTarget().getClass();
        //这个请求所在的包名，即应使用的database
        String pointClassName = pointClass.getName();
        String want_dataSource = pointClassName.substring(databaseIndex, pointClassName.indexOf(".", databaseIndex));

        //切换数据源
        DataSourceHolder.setDataSources("dataSource_" + want_dataSource);
    }

    /**
     * 当操作完成时,释放当前的数据源 如果不释放,频繁点击时会发生数据源冲突,本是另一个数据源的表,结果跑到另外一个数据源去,报表不存在
     *
     * @param joinPoint
     * @throws Throwable
     */
    @After("execution(* com.my..*Controller.*(..))")
    public void removeDataSoruce(JoinPoint joinPoint) throws Throwable {
        DataSourceHolder.setDataSources(null);
    }

}
