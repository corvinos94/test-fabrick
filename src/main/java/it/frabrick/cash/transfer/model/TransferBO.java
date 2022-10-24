package it.frabrick.cash.transfer.model;

import it.frabrick.cash.common.model.BasicModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferBO extends BasicModel {

	private TransferModelBO payload;
}
