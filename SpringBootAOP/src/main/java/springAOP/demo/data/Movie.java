package springAOP.demo.data;

import org.springframework.stereotype.Repository;

@Repository
public class Movie {
	
	public String getMovieDetails() {
		return "\nmovie details :{Bhahubali,RRR,Liger}\n";		
	}

}
