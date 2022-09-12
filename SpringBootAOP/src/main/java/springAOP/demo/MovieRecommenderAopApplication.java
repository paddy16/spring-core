package springAOP.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springAOP.demo.business.ContentBasedFiltering;
import springAOP.demo.business.UserWatchHistory;

@SpringBootApplication
public class MovieRecommenderAopApplication implements CommandLineRunner {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ContentBasedFiltering filter1;
	
	@Autowired
	private UserWatchHistory filter2;
		
	public static void main(String[] args) {
		SpringApplication.run(MovieRecommenderAopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("#################### AOP : Intercepting Before actual business methos execution ########################");
		
		logger.info("{}",filter1.contentBasedFiltering());
		logger.info("{}",filter2.collaborativeFiltering());
		
	}

}
