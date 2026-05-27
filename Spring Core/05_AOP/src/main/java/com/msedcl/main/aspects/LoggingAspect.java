package com.msedcl.main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(void com.msedcl.main.service.UserService.createUser(String))")
	public void logging() {
	}

	@Around("logging()")
	public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("[Around] advice called before method execution start");

		proceedingJoinPoint.proceed();

		System.out.println("[Around] advice called after method execution complete");
	}

	@Before("logging()")
	public void logBeforeThree(JoinPoint joinPoint) {
		System.out.println("[BeforeThree] advice called for method :: " + joinPoint.getSignature().getName());
	}

	@Before("logging()")
	public void logBeforeX(JoinPoint joinPoint) {
		System.out.println("[BeforeX] advice called for method :: " + joinPoint.getSignature().getName());
	}

	// @Before("execution(* com.msedcl.main.service.*.*(..))")
	@Before("logging()")
	public void logBeforeZ(JoinPoint joinPoint) {
		System.out.println("[BeforeZ] advice called for method :: " + joinPoint.getSignature().getName());
	}

	@After("logging()")
	public void logAfter() {
		System.out.println("[After] advice called");
	}
}
