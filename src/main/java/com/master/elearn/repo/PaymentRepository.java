package com.master.elearn.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.master.elearn.entity.Payments;

import java.util.List;

/**
 * Repository interface for Payment entity.
 */
public interface PaymentRepository extends JpaRepository<Payments, Long> {
    List<Payments> findBySuccessTrue();
}