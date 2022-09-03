package stereotype.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentBasedFilter implements Filter {
	
	
	@Autowired
	private Movie movie;

	public ContentBasedFilter() {
		super();
	}
	
	public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"}; //online feed
    }

}
