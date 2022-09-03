package springcore.xml.annotations;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans-cs.xml");

		// check the beans which have been loaded
		System.out.println("\nBeans loaded:");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

		System.out.println("\n############## Constructor Injection #######################");
		
		
		/**
		 *  1. Constructor injection
		 */
		// use ApplicationContext to find which filter is being usedŒ
		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
		
		// call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");

		// display results
		System.out.println(Arrays.toString(result));
		System.out.println(" \n");
		
		
	}

}
