package com.xxx.springbootfordruid.log;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/*
 * 结论：执行顺序
 * ①around(前)
 * ②before
 * ③业务逻辑
 * ④afterthrowing
 * ⑤around(后)
 * ⑥after
 * ⑦afterreturning
 */
@Component
@Aspect
public class ControllerAspect {

	@Before("execution(* com.xxx.springbootfordruid.controller.*.*(..))")
	public void testbefore(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("@Before方法名称为：" + method.getName());
	}

	@After("execution(* com.xxx.springbootfordruid.controller.*.*(..))")
	public void testafter(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("@After方法名称为：" + method.getName());
	}

	@AfterReturning("execution(* com.xxx.springbootfordruid.controller.*.*(..))")
	public void testafterreturning(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("@AfterReturning方法名称为：" + method.getName());
	}

	@AfterThrowing(value = "execution(* com.xxx.springbootfordruid..*.*(..))", throwing = "exception")
	public void testafterthrowing(JoinPoint point, RuntimeException exception) {
		System.out.println("@AfterThrowing异常为：" + exception.getMessage());
	}
	
	@Around("execution(* com.xxx.springbootfordruid.controller.*.*(..))")
	public Object testaround(ProceedingJoinPoint joinPoint) {
		System.out.println("@Around执行后后后方法执行前");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("@Around执行后后后方法名称为：" + method.getName());
		
		return result;
	}
	
	@Around("@annotation(com.xxx.springbootfordruid.log.ControllerLogAnnotation)")
	public Object testannitation(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		ControllerLogAnnotation annotation = method.getAnnotation(ControllerLogAnnotation.class);
		String desc = annotation.desc();
		Object[] args = joinPoint.getArgs();
		System.err.println("我是注解方法前，desc=" + desc + ",args=" + Arrays.toString(args));
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.err.println("我是注解方法后，desc=" + desc + ",args=" + Arrays.toString(args));

		return result;
	}
}
