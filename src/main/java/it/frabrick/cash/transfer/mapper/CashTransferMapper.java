package it.frabrick.cash.transfer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import it.frabrick.cash.transfer.model.CashTransferBO;
import it.frabrick.cash.transfer.model.CashTransferRequest;
import it.frabrick.cash.transfer.model.CashTransferResponse;
import it.frabrick.cash.transfer.model.TransferBO;

@Mapper
public interface CashTransferMapper {

	@Mappings({
		@Mapping(target = "creditor.name", source = "request.receiverName"),
		@Mapping(target = "creditor.account.accountCode", source = "request.accountCode"),
	})
	public CashTransferBO cashTransferRequest2CashTransfer(CashTransferRequest request);
	
	@Mappings({
		@Mapping(target = "statusOperation", source = "transfer.payload.status"),
		@Mapping(target = "description", expression = "java(\"Operazione effettuata con successo\")")
	})
	public CashTransferResponse transfer2CashTransferResponse(TransferBO transfer);
}
