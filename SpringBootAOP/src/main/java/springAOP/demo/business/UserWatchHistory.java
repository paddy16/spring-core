package springAOP.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springAOP.demo.data.User;

@Service
public class UserWatchHistory {
	
	@Autowired
	private User user;
	
	public String collaborativeFiltering() {
		String userDetails =  user.getUserDetails();
		return userDetails;
	}

}
