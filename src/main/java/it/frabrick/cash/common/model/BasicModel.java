package it.frabrick.cash.common.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicModel {

	private String status;
	private List<ErrorModel> errors;
}
