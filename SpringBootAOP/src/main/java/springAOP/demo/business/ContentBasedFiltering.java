package springAOP.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springAOP.demo.data.Movie;

@Service
public class ContentBasedFiltering {
	
	@Autowired
	private Movie movie;
	
	public String contentBasedFiltering() {
		String movieDetails = movie.getMovieDetails();
		return movieDetails;
	}

}
