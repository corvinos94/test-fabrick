package it.frabrick.cash.transfer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferModelBO {

	private String moneyTransferId;
	private String status;
	private String direction;
}
