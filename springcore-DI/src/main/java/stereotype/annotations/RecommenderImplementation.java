package stereotype.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommenderImplementation {
	
	@Autowired
    private Filter filter;
            
	public RecommenderImplementation(Filter filter) {
		this.filter = filter;
	}
	
    
	public Filter getFilter() {
		return filter;
	}

	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + filter + "\n");

	    String[] results = filter.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
