package it.frabrick.cash.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CashErrorResponse {

	private String status;
	private String code;
	private String description;
}
