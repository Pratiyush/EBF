package de.ebf.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *  BootApp starts-up as non daemon thread.  
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@EnableJpaRepositories(basePackages = "de.ebf.employee.repository" )
@SpringBootApplication
public class BootApp {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BootApp.class);

	public static void main(String[] args) {
		LOGGER.info("Starting EBF Employee Admin App ");
		SpringApplication.run(BootApp.class, args);
		LOGGER.info("EBF Employee Admin App Started");
		
	}
}
