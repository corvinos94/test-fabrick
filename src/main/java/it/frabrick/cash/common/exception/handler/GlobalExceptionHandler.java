package it.frabrick.cash.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.frabrick.cash.common.exception.CashPersistenceException;
import it.frabrick.cash.common.exception.CashServiceException;
import it.frabrick.cash.common.model.CashErrorResponse;
import it.frabrick.cash.common.model.StatusCode;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CashServiceException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CashErrorResponse> handleAllCaughtException(CashServiceException exception) {
		log.error(exception.getCode() + " - " + exception.getMessage(), exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CashPersistenceException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CashErrorResponse> handleAllPersistenceException(CashPersistenceException exception) {
		log.error(StatusCode.CODE_TF002.toString() + " - " + exception.getMessage(), exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CashErrorResponse> handleAllUncaughtException(RuntimeException exception) {
		log.error(exception.getMessage(), exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ResponseEntity<CashErrorResponse> buildErrorResponse(CashServiceException exception, HttpStatus httpStatus) {
		CashErrorResponse errorResponse = new CashErrorResponse(StatusCode.STATUS_KO.toString(), exception.getCode(), exception.getMessage());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
	
	private ResponseEntity<CashErrorResponse> buildErrorResponse(CashPersistenceException exception, HttpStatus httpStatus) {
		CashErrorResponse errorResponse = new CashErrorResponse(StatusCode.STATUS_KO.toString(), StatusCode.CODE_TF002.toString(), "Persistence error");
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
	
	private ResponseEntity<CashErrorResponse> buildErrorResponse(RuntimeException exception, HttpStatus httpStatus) {
		CashErrorResponse errorResponse = new CashErrorResponse(StatusCode.STATUS_KO.toString(), StatusCode.CODE_TF001.toString(), "Generic error");
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
