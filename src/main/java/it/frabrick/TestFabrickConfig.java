package it.frabrick;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import it.frabrick.cash.client.HeaderSourceProperties;
import it.frabrick.cash.client.interceptor.HeaderRequestInterceptor;

@Configuration
@ComponentScan(basePackages = {
		TestFabrickConfig.IT_FABRICK_PACKAGE	
})
public class TestFabrickConfig {
	
	public static final String IT_FABRICK_PACKAGE = "it.fabrick";
   
	@Autowired
    DataSourceProperties dataSourceProperties;
	
	@Autowired
	HeaderSourceProperties headerSourceProperties;
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
    	List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    	interceptors.add(new HeaderRequestInterceptor(this.headerSourceProperties.getNameAuthSchema(), this.headerSourceProperties.getAuthSchema()));
		interceptors.add(new HeaderRequestInterceptor(this.headerSourceProperties.getNameApiKey(), this.headerSourceProperties.getApiKey()));
    	
    	return builder.additionalInterceptors(interceptors).build();
    }
}