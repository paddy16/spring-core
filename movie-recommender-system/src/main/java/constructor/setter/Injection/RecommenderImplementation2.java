package constructor.setter.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
public class RecommenderImplementation2 {

	private Filter filter;
//constructor injection

	@Autowired
	public RecommenderImplementation2(@Qualifier("collaborativeFilter") Filter filter) {
		super();
		this.filter = filter;
		System.out.println("Constructor invoked...");
	}

	public String[] recommendMovies(String movie) {

		// print the name of interface implementation being used
		System.out.println("Name of the filter in use: " + filter + "\n");

		String[] results = filter.getRecommendations("Finding Dory");

		return results;
	}

}
