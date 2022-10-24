package it.frabrick.cash.transactions.model;

import it.frabrick.cash.common.model.BasicModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsBO extends BasicModel {

	private TransactionsPayloadBO payload;
}
