package it.frabrick.cash.transactions.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.frabrick.cash.transactions.manager.CashTransactionsManagerI;
import it.frabrick.cash.transactions.mapper.CashTransactionsMapper;
import it.frabrick.cash.transactions.model.CashTransactionsResponse;
import it.frabrick.cash.transactions.model.TransactionsBO;

@RestController
@RequestMapping("/api")
public class CashTransactions {

	@Autowired
	CashTransactionsManagerI cashTransactionsManager;
	
	CashTransactionsMapper cashTransactionsMapper;
	
	@GetMapping("/cash-transactions/{accountId}")
	public CashTransactionsResponse getCashTransactions(@PathVariable String accountId, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) {
		TransactionsBO transactions = cashTransactionsManager.getTransactions(accountId, fromAccountingDate, toAccountingDate);
		return cashTransactionsMapper.transactions2CashTransactionsResponse(transactions);
	}
}
