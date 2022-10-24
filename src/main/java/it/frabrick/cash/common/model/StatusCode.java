package it.frabrick.cash.common.model;

public enum StatusCode {

	CODE_TF001("TF001"),
	CODE_TF002("TF002"),
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
