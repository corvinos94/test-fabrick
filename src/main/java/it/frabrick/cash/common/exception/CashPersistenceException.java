package it.frabrick.cash.common.exception;

public class CashPersistenceException extends RuntimeException {

	private static final long serialVersionUID = -4784428672501357078L;

	public CashPersistenceException(String message, Throwable trow) {
		super(message, trow);
	}
}
