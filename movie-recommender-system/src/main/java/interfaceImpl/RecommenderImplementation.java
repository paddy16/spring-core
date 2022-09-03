package interfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import model.Filter;

public class RecommenderImplementation {
	
	
	@Autowired
    private Filter filter;
            
    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }
	
		
	
	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + filter + "\n");

	    String[] results = filter.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
