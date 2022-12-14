package it.frabrick.cash.transactions.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsModelBO {

	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private TransactionTypeBO type;
    private Double amount;
    private String currency;
    private String description;
}
