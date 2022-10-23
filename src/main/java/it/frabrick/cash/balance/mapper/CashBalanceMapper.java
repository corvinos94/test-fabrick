package it.frabrick.cash.balance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import it.frabrick.cash.balance.model.CashBO;
import it.frabrick.cash.balance.model.CashBalanceResponse;

@Mapper
public interface CashBalanceMapper {

	@Mappings({
		@Mapping(target = "date", source = "cash.payload.date"),
		@Mapping(target = "balance", source = "cash.payload.balance"),
		@Mapping(target = "avaibleBalance", source = "cash.payload.avaibleBalance")
	})
	public CashBalanceResponse cash2CashBalanceResponse(CashBO cash);
}
