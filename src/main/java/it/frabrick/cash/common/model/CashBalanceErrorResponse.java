package it.frabrick.cash.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CashBalanceErrorResponse {

	private String code;
	private String description;
}
