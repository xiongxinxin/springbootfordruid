package com.xxx.springbootfordruid.log;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 访问controller层的注解
 * @author xiong.xinxin
 * @date 2019-9-28
 */

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface ControllerLogAnnotation {
	String desc() default "";
}
