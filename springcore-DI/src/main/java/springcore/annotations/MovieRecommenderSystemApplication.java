package springcore.annotations;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		// ApplicationContext manages the beans and dependencies
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				MovieRecommenderSystemApplication.class);

		// use ApplicationContext to find which filter is being usedŒ
		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

		// call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");

		// display results
		System.out.println(Arrays.toString(result));
	}

}
