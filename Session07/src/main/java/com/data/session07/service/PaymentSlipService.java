package com.data.session07.service;

import com.data.session07.model.entity.PaymentSlip;
import java.util.List;

public interface PaymentSlipService {
    List<PaymentSlip> getAllPaymentSlips();
    PaymentSlip getPaymentSlipById(Long id);
    PaymentSlip addPaymentSlip(PaymentSlip paymentSlip);
}
