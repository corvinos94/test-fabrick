package it.frabrick.cash.transfer.model;

import it.frabrick.cash.common.model.GenericResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransferResponse extends GenericResponse {

	private String statusOperation;
	private String description;
}
