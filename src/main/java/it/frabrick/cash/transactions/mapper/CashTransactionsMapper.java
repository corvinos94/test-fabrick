package it.frabrick.cash.transactions.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import it.frabrick.cash.transactions.model.CashTransactionsResponse;
import it.frabrick.cash.transactions.model.TransactionsBO;

@Mapper
public interface CashTransactionsMapper {

	@Mappings({
		@Mapping(target = "list", source = "transactions.payload.list")
	})
	public CashTransactionsResponse transactions2CashTransactionsResponse(TransactionsBO transactions);
}
