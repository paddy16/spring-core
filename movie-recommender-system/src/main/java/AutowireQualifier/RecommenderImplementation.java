package AutowireQualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
public class RecommenderImplementation {
	
	
   //using qualifier with different name as parameter
	@Autowired
	//@Qualifier("CBF")
	@Qualifier("CBF")
	private Filter filterImpl;
	
		
	
	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + filterImpl + "\n");

	    String[] results = filterImpl.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
