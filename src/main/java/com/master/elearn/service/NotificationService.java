package com.master.elearn.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.master.elearn.events.PaymentSuccessEvent;

/**
 * Service class for managing Notifications.
 */
@Service
public class NotificationService {
    @EventListener
    public void handlePaymentSuccessEvent(PaymentSuccessEvent event) {
        String recipient = event.getPayment().getStudentName();
        String message = "Your payment for " + event.getPayment().getCourse().getTitle() + " was successful.";
        sendNotification(recipient, message);
    }

    public void sendNotification(String recipient, String message) {
        // Simulate sending an email notification
        org.slf4j.LoggerFactory.getLogger(NotificationService.class).info("Sending notification to {}: {}", recipient, message);
    }
}