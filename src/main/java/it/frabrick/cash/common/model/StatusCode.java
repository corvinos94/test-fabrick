package it.frabrick.cash.common.model;

public enum StatusCode {

	STATUS_OK("OK"),
	STATUS_KO("KO");

	private final String code;
	
	StatusCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
