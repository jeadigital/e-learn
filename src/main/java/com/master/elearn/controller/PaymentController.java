package com.master.elearn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.master.elearn.entity.Payments;
import com.master.elearn.service.PaymentService;

import java.util.List;

/**
 * REST Controller for managing Payments.
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping
    public ResponseEntity<Payments> makePayment(@RequestBody Payments payment) {
        return ResponseEntity.ok(paymentService.makePayment(payment));
    }
}
