package it.frabrick.cash.transactions.mapper;

import org.mapstruct.Mapper;

import it.frabrick.cash.transactions.model.CashTransactionsResponse;
import it.frabrick.cash.transactions.model.TransactionsBO;

@Mapper
public interface CashTransactionsMapper {

	public CashTransactionsResponse transactions2CashTransactionsResponse(TransactionsBO transactions);
}
