package constructor.setter.Injection;

import org.springframework.stereotype.Component;

import model.Filter;

@Component("CF")  // we can use @Qualifier("CF")
public class CollaborativeFilter implements Filter {
	
	 public String[] getRecommendations(String movie) {
	        //logic of collaborative filter
		 String user1Watched = "Ice Age";
		 String user2Watched = "Ice Age";

			if (user1Watched.contentEquals(user2Watched)) {

				return new String[] { "Ice Age" };
			} else {

				return new String[] { "Happy Feet" };
			}

		}

}
