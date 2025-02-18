package com.master.elearn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.Payments;
import com.master.elearn.events.PaymentSuccessEvent;
import com.master.elearn.repo.PaymentRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service class for managing Payments.
 */
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    public List<Payments> getAllPayments() {
        return paymentRepository.findBySuccessTrue();
    }

    public Payments makePayment(Payments payment) {
        payment.setPaymentDate(LocalDateTime.now());
        payment.setSuccess(true);
        Payments savedPayment =  paymentRepository.save(payment);
        // Publish payment success event
        eventPublisher.publishEvent(new PaymentSuccessEvent(this, savedPayment));
        
        return savedPayment;
    }
}