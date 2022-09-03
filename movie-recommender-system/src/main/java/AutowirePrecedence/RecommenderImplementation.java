package AutowirePrecedence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
public class RecommenderImplementation {
	
	//Autowired ByType
	@Autowired
    private Filter contentBasedFilter;
	/*
	 * public RecommenderImplementation(Filter filter) { super(); this.filter =
	 * filter; }
	 */
		
	
	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + contentBasedFilter + "\n");

	    String[] results = contentBasedFilter.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
