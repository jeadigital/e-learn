package com.master.elearn.events;


import com.master.elearn.entity.Payments;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event triggered when a payment is successfully processed.
 */
@Getter
public class PaymentSuccessEvent extends ApplicationEvent {
    private final Payments payment;

    public PaymentSuccessEvent(Object source, Payments payment) {
        super(source);
        this.payment = payment;
    }
}