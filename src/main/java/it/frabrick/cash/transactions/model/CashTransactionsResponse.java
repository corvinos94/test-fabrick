package it.frabrick.cash.transactions.model;

import java.util.List;

import it.frabrick.cash.common.model.GenericResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransactionsResponse extends GenericResponse {

	List<CashTransactions> list;
}
