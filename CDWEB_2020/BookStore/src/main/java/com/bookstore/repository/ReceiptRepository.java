package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
	
}
