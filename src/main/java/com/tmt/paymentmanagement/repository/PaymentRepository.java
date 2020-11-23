package com.tmt.paymentmanagement.repository;

import com.tmt.paymentmanagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
