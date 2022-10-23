package it.frabrick.cash.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashServiceException extends RuntimeException {

	private static final long serialVersionUID = -6829017058398588008L;
	
	private String code;
	
	public CashServiceException(String code, String message, Throwable trow) {
		super(message, trow);
		setCode(code);
	}
}
