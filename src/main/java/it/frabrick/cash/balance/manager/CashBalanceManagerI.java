package it.frabrick.cash.balance.manager;

import it.frabrick.cash.balance.model.Cash;

public interface CashBalanceManagerI {

	public Cash getBalance(String accountId);
}
