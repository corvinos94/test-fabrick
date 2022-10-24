package it.frabrick.cash.transfer.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import it.frabrick.cash.client.RestTemplateFabrickClient;
import it.frabrick.cash.client.ServiceSourceProperties;
import it.frabrick.cash.common.exception.CashServiceException;
import it.frabrick.cash.common.exception.handler.GlobalExceptionUtil;
import it.frabrick.cash.common.model.ErrorModel;
import it.frabrick.cash.transfer.model.CashTransferBO;
import it.frabrick.cash.transfer.model.TransferBO;

@Component
public class CashTransferManager implements CashTransferManagerI {

	private static final String CREATE_MONEY_TRANSFER_API = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";
	@Autowired
	ServiceSourceProperties serviceSourceProperties;
	
	@Autowired
	RestTemplateFabrickClient<TransferBO> restTemplate;
	
	@Autowired
	GlobalExceptionUtil<TransferBO> exceptionUtil;
	
	@Override
	public TransferBO createCashTransfer(String accountId, CashTransferBO request) {
		TransferBO moneyTransfer = null;
		try {
			moneyTransfer = restTemplate.post(serviceSourceProperties.getBaseUrl() + CREATE_MONEY_TRANSFER_API, request, TransferBO.class, accountId);
		} catch (HttpClientErrorException e) {
			TransferBO moneyTransferError = exceptionUtil.buildErrorResponse(e, TransferBO.class);
			ErrorModel error = exceptionUtil.getErrorModel(moneyTransferError);
			throw new CashServiceException(error.getCode(), error.getDescription(), e);
		}
		return moneyTransfer;
	}
}
