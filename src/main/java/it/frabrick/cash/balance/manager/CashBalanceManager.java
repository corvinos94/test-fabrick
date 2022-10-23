package it.frabrick.cash.balance.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import it.frabrick.cash.balance.model.CashBO;
import it.frabrick.cash.client.RestTemplateFabrickClient;
import it.frabrick.cash.client.ServiceSourceProperties;
import it.frabrick.cash.common.exception.CashServiceException;
import it.frabrick.cash.common.exception.handler.GlobalExceptionUtil;
import it.frabrick.cash.common.model.ErrorModel;

@Component
public class CashBalanceManager implements CashBalanceManagerI {

	private static final String CASH_ACCOUNT_BALANCE_API = "/api/gbs/banking/v4.0/accounts/{accountId}/balance";
	
	@Autowired
	ServiceSourceProperties serviceSourceProperties;
	
	@Autowired
	RestTemplateFabrickClient<CashBO> restTemplate;
	
	@Autowired
	GlobalExceptionUtil<CashBO> exceptionUtil;
	
	@Override
	public CashBO getBalance(String accountId) {
		CashBO cashBalance = null;
		try {
			cashBalance = restTemplate.get(this.serviceSourceProperties.getBaseUrl() + CASH_ACCOUNT_BALANCE_API, CashBO.class, accountId);
		} catch (HttpClientErrorException e) {
			CashBO cashError = exceptionUtil.buildErrorResponse(e, CashBO.class);
			ErrorModel error = exceptionUtil.getErrorModel(cashError);
			throw new CashServiceException(error.getCode(), error.getDescription(), e);
		}
		return cashBalance;
	}
}
