package it.frabrick.cash.transactions.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsPayloadBO {

	private List<TransactionsModelBO> list;
}
