package com.keduit.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice{
	
	//맨 앞 *은 접근제어자, 두번째 *은 클래스, 세번째 *은 메서드, (..)은 매개변수이다.
	@Before("execution(* com.keduit.service.SampleService*.*(..))") 
	public void logBefore() {
		log.info("================");
	}

	
	@Before("execution(* com.keduit.service.SampleService*.doAdd(String, String))"+" && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("---logBeforeWithParam---");
		log.info("str1 : " + str1);
		log.info("str2 : " + str2);
	}
	
	@AfterThrowing(pointcut="execution(* com.keduit.service.SampleService*.*(..))", 
			throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception....!!!!");
		log.info("exception : " + exception);
		
	}
	
	@Around("execution(* com.keduit.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		log.info("Target : " + pjp.getTarget());
		log.info("param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
			
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis(); 
		log.info("Time : " + (end-start));
		return result;
		
	}
}
