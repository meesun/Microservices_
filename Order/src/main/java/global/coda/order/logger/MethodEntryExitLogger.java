package global.coda.order.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Aspect
@Configuration
@Log4j2
public class MethodEntryExitLogger {

	@Before("execution(* global.coda.order..*.*(..))")
	public void logEntry(JoinPoint joinPoint) {
		log.trace("Entering " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
	}

	@After("execution(* global.coda.order..*.*(..))")
	public void logExit(JoinPoint joinPoint) {
		log.trace("Exiting " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
	}

}
