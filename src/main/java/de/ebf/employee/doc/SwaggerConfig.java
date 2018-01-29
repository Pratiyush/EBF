 package de.ebf.employee.doc;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2 is configured in this class for documentation automation.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */ 
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())  
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "REST API", 
          "Employee Storage Service for Companies" ,
          "API TOS", 
          "Terms of service", 
          new Contact("John Doe", "https://employee.ebf.de", "ebf.employee@ebf.de"), 
          "License of API", "API license URL", Collections.emptyList());
   }
} 