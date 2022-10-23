package it.frabrick.cash.balance.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceModel {
	
	private String date;
	private Double balance;
	private Double avaibleBalance;
	private String currency;
}
