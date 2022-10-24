package it.frabrick.cash.transactions.manager;

import java.util.List;

import it.frabrick.cash.transactions.model.CashTransactions;
import it.frabrick.cash.transactions.model.TransactionsBO;

public interface CashTransactionsManagerI {

	public TransactionsBO getTransactions(String accountId, String fromDate, String toDate);
	
	public void saveTransactions(List<CashTransactions> transactions);
}
