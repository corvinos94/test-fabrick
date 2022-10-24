package it.frabrick.cash.transfer.mapper;

import org.mapstruct.Mapper;

import it.frabrick.cash.transfer.model.CashTransferBO;
import it.frabrick.cash.transfer.model.CashTransferRequest;
import it.frabrick.cash.transfer.model.CashTransferResponse;
import it.frabrick.cash.transfer.model.TransferBO;

@Mapper
public interface CashTransferMapper {

	public CashTransferBO cashTransferRequest2CashTransfer(CashTransferRequest request);
	
	public CashTransferResponse transfer2CashTransferResponse(TransferBO transfer);
}
