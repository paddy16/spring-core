package springcore.xml;

import model.Filter;

public class RecommenderImplementation2 {
	
    private Filter filter;
            
    
	public Filter getFilter() {
		return filter;
	}


	public void setFilter(Filter filter) {
		this.filter = filter;
	}


	public String [] recommendMovies (String movie) {
        
	    //print the name of interface implementation being used
	    System.out.println("Name of the filter in use: " + filter + "\n");

	    String[] results = filter.getRecommendations("Finding Dory");
	    
	    return results;
	}
   
}
