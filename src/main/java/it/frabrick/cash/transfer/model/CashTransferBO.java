package it.frabrick.cash.transfer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransferBO {

	private CreditorBO creditor;
	private String description;
	private Double amount;
	private String currency;
}
