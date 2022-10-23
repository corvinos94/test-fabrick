package it.frabrick.cash.balance.manager;

import it.frabrick.cash.balance.model.CashBO;

public interface CashBalanceManagerI {

	public CashBO getBalance(String accountId);
}
