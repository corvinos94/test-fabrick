package it.frabrick.cash.balance.model;

import it.frabrick.cash.common.model.BasicModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashBO extends BasicModel {
	
	private BalanceModelBO payload;
}
