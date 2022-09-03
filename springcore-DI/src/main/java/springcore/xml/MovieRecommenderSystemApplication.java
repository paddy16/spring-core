package springcore.xml;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");

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
		
		System.out.println("\n############## Setter Injection #######################");
		/**
		 *  2. setter Injection
		 */
		// use ApplicationContext to find which filter is being usedŒ
		RecommenderImplementation2 recommender2 = appContext.getBean(RecommenderImplementation2.class);
		
		// call method to get recommendations
		String[] result2 = recommender2.recommendMovies("Finding Dory");

		// display results
		System.out.println(Arrays.toString(result2));
	}

}
