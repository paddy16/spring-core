package interfaceImpl;

import java.util.Arrays;

import model.ContentBasedFilter;

public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		
		//passing name of the filter as constructor argument
		RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());
		
		//let's change the code to use collaborative filter
		//RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());
		
		//call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");
		
		//display results
		System.out.println(Arrays.toString(result));
	}

}
