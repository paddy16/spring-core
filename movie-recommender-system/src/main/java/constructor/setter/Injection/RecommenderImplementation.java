package constructor.setter.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
public class RecommenderImplementation {
	
	
	private Filter filter;

	// setter injection
	@Autowired
	@Qualifier("contentBasedFilter")
	public void setFilter(Filter filter) {
		this.filter = filter;
		System.out.println("Setter method invoked..");
	}
	
	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + filter + "\n");

	    String[] results = filter.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
