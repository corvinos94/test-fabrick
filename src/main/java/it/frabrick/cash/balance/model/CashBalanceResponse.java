package it.frabrick.cash.balance.model;

import it.frabrick.cash.common.model.GenericResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashBalanceResponse extends GenericResponse {

	private String date;
	private Double balance;
	private Double avaibleBalance;
}
