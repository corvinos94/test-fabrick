package it.frabrick.cash.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class HeaderSourceProperties {

	@Value("${header.authSchema.name}")
	private String nameAuthSchema;
	@Value("${header.authSchema.value}")
	private String authSchema;
	
	@Value("${header.apiKey.name}")
	private String nameApiKey;
	@Value("${header.apiKey.value}")
	private String apiKey;
}
