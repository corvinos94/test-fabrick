package it.frabrick.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.frabrick.cash.transactions.model.CashTransactions;
import it.frabrick.persistence.model.Transaction;

@Mapper
public interface CashTransactionsEntityMapper {

	public List<Transaction> cashTransactions2Transactions(List<CashTransactions> list);
}
