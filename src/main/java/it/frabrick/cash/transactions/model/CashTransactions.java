package it.frabrick.cash.transactions.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransactions {

	private String transactionId;
	private String operationId;
	private String valueDate;
	private Double amount;
	private String currency;
	private String description;
}
