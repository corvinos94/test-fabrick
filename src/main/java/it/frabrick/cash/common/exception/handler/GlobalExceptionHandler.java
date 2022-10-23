package it.frabrick.cash.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.frabrick.cash.common.exception.CashServiceException;
import it.frabrick.cash.common.model.CashBalanceErrorResponse;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CashServiceException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CashBalanceErrorResponse> handleAllUncaughtException(CashServiceException exception) {
		log.error(exception.getCode() + " - " + exception.getMessage(), exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<CashBalanceErrorResponse> buildErrorResponse(CashServiceException exception, HttpStatus httpStatus) {
		CashBalanceErrorResponse errorResponse = new CashBalanceErrorResponse(exception.getCode(), exception.getMessage());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
