package it.frabrick.cash.transfer.manager;

import it.frabrick.cash.transfer.model.CashTransferBO;
import it.frabrick.cash.transfer.model.TransferBO;

public interface CashTransferManagerI {
	
	public TransferBO createCashTransfer(String accountId, CashTransferBO request);
}
