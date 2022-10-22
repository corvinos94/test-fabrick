package it.frabrick.cash.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ServiceSourceProperties {

	@Value("${service.baseUrl.value}")
	private String baseUrl;
}
