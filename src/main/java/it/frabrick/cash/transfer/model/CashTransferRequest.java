package it.frabrick.cash.transfer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransferRequest {

	private String accountId;
	private String receiverName;
	private String description;
	private String currency;
	private Double amount;
	private String executionDate;
}
