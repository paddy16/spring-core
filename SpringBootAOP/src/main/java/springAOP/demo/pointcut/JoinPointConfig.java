package springAOP.demo.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {
	
	//intercept all data layer methods
	@Pointcut("execution(* springAOP.demo.data.*.*(..))")
	public void dataLayerPointcut() {}
	
	//Intercept all business layer methods
	@Pointcut("execution(* springAOP.demo.business.*.*(..))")
	public void businessLayerPointcut() {}
	
	//to intercept method calls for both layers:
	@Pointcut("springAOP.demo.pointcut.JoinPointConfig.dataLayerPointcut() && "
			+ "springAOP.demo.pointcut.JoinPointConfig.businessLayerPointcut()")
	public void allLayersPointcut() {}
	//for specific beans
	@Pointcut("bean(movie*)")
	public void movieBeanPointcut() {}
	
	// custom aspect annotation
	@Pointcut("@annotation(springAOP.demo.aspect.MeasureTime)")
	public void measureTimeAnnotation() {
	}

}
