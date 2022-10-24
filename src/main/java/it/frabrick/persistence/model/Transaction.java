package it.frabrick.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CASH_TRANSACTION")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
 
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "OPERATION_ID")
	private String operationId;
	
	@Column(name = "VALUE_DATE")
	private String valueDate;
	
	@Column(name = "AMOUNT")
	private String amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "DESCRIPTION")
	private String description;
}
