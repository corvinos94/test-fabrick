package it.frabrick;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import it.frabrick.cash.client.HeaderSourceProperties;
import it.frabrick.cash.client.interceptor.HeaderRequestInterceptor;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

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
    //@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    DataSource realDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        return dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new DataSourceSpy(realDataSource());
    }
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
    	List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    	interceptors.add(new HeaderRequestInterceptor(this.headerSourceProperties.getNameAuthSchema(), this.headerSourceProperties.getAuthSchema()));
		interceptors.add(new HeaderRequestInterceptor(this.headerSourceProperties.getNameApiKey(), this.headerSourceProperties.getApiKey()));
    	
    	return builder.additionalInterceptors(interceptors).build();
    }
}