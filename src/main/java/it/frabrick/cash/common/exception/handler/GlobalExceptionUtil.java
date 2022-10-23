package it.frabrick.cash.common.exception.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.frabrick.cash.common.model.BasicModel;
import it.frabrick.cash.common.model.ErrorModel;

@Component
public class GlobalExceptionUtil<T extends BasicModel> {

	public T buildErrorResponse(HttpClientErrorException e, Class<T> clazz) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(e.getResponseBodyAsString(), clazz);
	}
	
	public ErrorModel getErrorModel(T obj) {
		if(obj.getErrors() != null && !obj.getErrors().isEmpty()) {
			return obj.getErrors().get(0);
		}
		return null;
	}
}
