package impl;

import model.ContentBasedFilter;

public class RecommenderImplementation {
	
	public String[] recommendMovies (String movie) {
		//use content based filter to find similar movies. it is tightly 
		//coupled with Recommender Implementation
        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations("Finding Dory");
        //return the results
        return results;
    }
}
