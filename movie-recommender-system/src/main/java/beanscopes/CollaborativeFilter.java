package beanscopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import model.Filter;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype")
public class CollaborativeFilter implements Filter {

	public CollaborativeFilter() {
		super();
	}

	// getRecommendations takes a movie as input and returns a list of similar
	// movies
	public String[] getRecommendations(String movie) {

		// implement logic of collaborative filter

		// return movie recommendations
		return new String[] { "Finding Nemo", "Ice Age", "Toy Story" };
	}
}