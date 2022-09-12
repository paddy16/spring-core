package springAOP.demo.data;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	
	public String getUserDetails() {
		return "\n user watch history details are: {Scary1,FastAndFurious,Duranga}\n";		
	}

}
