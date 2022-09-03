package springcore.external.propertyfile;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		//load the spring configuration file
				ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

				//retrieve bean from the application context
				RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
				
				//display value read from external property file
				String favoriteMovie = recommender.returnFavoriteMovie();
				System.out.println("Favorite Movie name read from external Property file ====> "+favoriteMovie);
				
				//call method to get recommendations
				String[] result = recommender.recommendMovies(favoriteMovie);
				
				//display results
				System.out.println(Arrays.toString(result));
	}

}
