package com.my.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.my.commonEnum.ModelEnum;
import com.my.commonEnum.OperationEnum;

/**
 *	 注解的保留位置（枚举RetentionPolicy），RetentionPolicy可选值：
 *	SOURCE：注解仅存在于源码中，在class字节码文件中不包含
	CLASS：默认的保留策略，注解在class字节码文件中存在，但运行时无法获得
	RUNTIME：注解在class字节码文件中存在，在运行时可以通过反射获取到
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 	用来声明注解范围（枚举ElementType），ElementType可选值：
 * 	TYPE：接口、类、枚举、注解
    FIELD：字段、枚举的常量
    METHOD：方法
    PARAMETER：方法参数
    CONSTRUCTOR：构造函数
    LOCAL_VARIABLE：局部变量
    ANNOTATION_TYPE：注解
    PACKAGE：包
 */
@Target(ElementType.METHOD)
/**
 * 	声明子类可以继承此注解，如果一个类A使用此注解，则类A的子类也继承此注解
 */
@Inherited
/**
 * 	声明注解能够被javadoc等识别
 */
@Documented
/**
 * 	自定义日志注解
 * @author Administrator
 *
 */
public @interface LogAnnotation {
	
	//模块
	public ModelEnum model();
	
	//操作
	public OperationEnum operation();
	
}
