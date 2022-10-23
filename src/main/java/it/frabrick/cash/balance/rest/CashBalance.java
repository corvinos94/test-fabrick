package it.frabrick.cash.balance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.frabrick.cash.balance.manager.CashBalanceManagerI;
import it.frabrick.cash.balance.mapper.CashBalanceMapper;
import it.frabrick.cash.balance.model.Cash;
import it.frabrick.cash.balance.model.CashBalanceResponse;

@RestController
@RequestMapping("/api")
public class CashBalance {

	@Autowired
	CashBalanceManagerI cashBalanceManager;
	
	@Autowired
	CashBalanceMapper cashBalanceMapper;
	
	@GetMapping("/cash-balance/{accountId}")
	public CashBalanceResponse getCacheBalance(@PathVariable String accountId) {
		Cash cashBalance = cashBalanceManager.getBalance(accountId);
		return cashBalanceMapper.cash2CashBalanceResponse(cashBalance);
	}
}
