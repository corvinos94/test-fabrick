package it.frabrick.cash.transfer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.frabrick.cash.transfer.manager.CashTransferManagerI;
import it.frabrick.cash.transfer.mapper.CashTransferMapper;
import it.frabrick.cash.transfer.model.CashTransferBO;
import it.frabrick.cash.transfer.model.CashTransferRequest;
import it.frabrick.cash.transfer.model.CashTransferResponse;
import it.frabrick.cash.transfer.model.TransferBO;

@RestController
@RequestMapping("/api")
public class CashTransfer {
	
	@Autowired
	CashTransferManagerI cashTransferManager;
	
	@Autowired
	CashTransferMapper cashTransferMapper;
	
	@PostMapping("/money-transfer")
	public CashTransferResponse createMoneyTransfer(@RequestBody CashTransferRequest request) {
		CashTransferBO trasferInput = cashTransferMapper.cashTransferRequest2CashTransfer(request);
		TransferBO transferOutput = cashTransferManager.createCashTransfer(request.getAccountId(), trasferInput);
		return cashTransferMapper.transfer2CashTransferResponse(transferOutput);
	}
}
