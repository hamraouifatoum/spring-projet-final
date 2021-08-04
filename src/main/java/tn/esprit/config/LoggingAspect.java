package tn.esprit.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Before("execution(* tn.esprit.service.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("INFO : In method " + name + " : ");
	}

	@AfterReturning("execution(* tn.esprit.service.*.*(..))")
	public void logAfterSuccessfullyExecution(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("INFO : After execution method successfully " + name + " : ");
	}
	
	@AfterThrowing("execution(* tn.esprit.service.*.*(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("INFO : After execution method exception " + name + " : ");
	}
	
	@After("execution(* tn.esprit.service.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("INFO : After execution method " + name + " : ");
	}
}
