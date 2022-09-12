package springAOP.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Before("execution(* springAOP.demo.business.*.*(..))")
	//@Before("execution(* springAOP.demo.business.*.*Filtering(..)) || execution(String  springAOP.demo.business.*.*(..))")
	//@Before("execution(String springAOP.demo..*.*(String))")
	//@Before("execution(* springAOP.demo.business.*.*Filtering(..))")
	//@Before("execution(String * springAOP.demo.business.*.*(..))")
	//@Before("execution(*  springAOP.demo.business.*.*(String,..))")
	//@Before("springAOP.demo.pointcut.JoinPointConfig.movieBeanPointcut()")
	public void before(JoinPoint joinPoint) {
		//	logger.info("Intercepted method call");
		logger.info("Intercepted call before execution of: {}", joinPoint);
		logger.info("Given username is exist:"+joinPoint);
		//access check logic		
	}
	
}
