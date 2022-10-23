package it.frabrick.cash.transactions.manager;

import it.frabrick.cash.transactions.model.TransactionsBO;

public interface CashTransactionsManagerI {

	public TransactionsBO getTransactions(String accountId, String fromDate, String toDate);
}
