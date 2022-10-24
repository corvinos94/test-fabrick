package it.frabrick.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.frabrick.persistence.model.Transaction;

public interface CashTransactionsRepository extends JpaRepository<Transaction, Long>{

}
