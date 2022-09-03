package AutowireByName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
public class RecommenderImplementation {
	
	
   
	/*
	 * //Autowired Byname
	 * 
	 * @Autowired private Filter contentBasedFilter;
	 */
	
	@Autowired
	private Filter collaborativeFilter;
	/*
	 * public String [] recommendMovies (String movie) {
	 * 
	 * //print the name of interface implementation being used
	 * System.out.println("Name of the filter in use: " + contentBasedFilter +
	 * "\n");
	 * 
	 * String[] results = contentBasedFilter.getRecommendations("Finding Dory");
	 * 
	 * return results; }
	 */
	
	
	public String[] recommendMovies(String movie) {

		// print the name of interface implementation being used
		System.out.println("Name of the filter in use: " + collaborativeFilter + "\n");

		String[] results = collaborativeFilter.getRecommendations("Finding Dory");

		return results;
	}
   
}
