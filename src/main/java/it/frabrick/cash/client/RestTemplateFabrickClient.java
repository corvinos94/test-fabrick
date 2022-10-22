package it.frabrick.cash.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.frabrick.cash.common.model.BasicModel;

@Service
public class RestTemplateFabrickClient<T extends BasicModel> {

	@Autowired
	private RestTemplate restTemplate;
	
	public T get(String url, Class<T> obj, Object ...variables) {
		return restTemplate.getForObject(url, obj, variables);
	}
	
	public T post(String url, Object request, Class<T> obj) {
		return restTemplate.postForObject(null, request, obj);
	}
	
	public void put(String url, Object request, Object ...variables) {
		restTemplate.put(url, request, variables);
	}
	
	public void delete(String url, Object ...variables) {
		restTemplate.delete(url, variables);
	}
}
