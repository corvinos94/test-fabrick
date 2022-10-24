package it.frabrick.cash.transactions.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import it.frabrick.cash.client.RestTemplateFabrickClient;
import it.frabrick.cash.client.ServiceSourceProperties;
import it.frabrick.cash.common.exception.CashServiceException;
import it.frabrick.cash.common.exception.handler.GlobalExceptionUtil;
import it.frabrick.cash.common.model.ErrorModel;
import it.frabrick.cash.transactions.model.TransactionsBO;

@Component
public class CashTransactonsManager implements CashTransactionsManagerI {

	private static final String CASH_ACCOUNT_BALANCE_API = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={fromDate}&toAccountingDate={toDate}";
	
	@Autowired
	ServiceSourceProperties serviceSourceProperties;
	
	@Autowired
	RestTemplateFabrickClient<TransactionsBO> restTemplate;
	
	@Autowired
	GlobalExceptionUtil<TransactionsBO> exceptionUtil;
	
	@Override
	public TransactionsBO getTransactions(String accountId, String fromDate, String toDate) {
		TransactionsBO transactions = null;
		try {
			transactions = restTemplate.get(serviceSourceProperties.getBaseUrl() + CASH_ACCOUNT_BALANCE_API, TransactionsBO.class, accountId, fromDate, toDate);
		} catch (HttpClientErrorException e) {
			TransactionsBO transactionsError = exceptionUtil.buildErrorResponse(e, TransactionsBO.class);
			ErrorModel error = exceptionUtil.getErrorModel(transactionsError); 
			throw new CashServiceException(error.getCode(), error.getDescription(), e);
		}
		return transactions;
	}
}
