package com.data.session07.service.impl;

import com.data.session07.model.entity.PaymentSlip;
import com.data.session07.reponsitory.PaymentSlipRepository;
import com.data.session07.service.PaymentSlipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentSlipServiceImpl implements PaymentSlipService {

    private final PaymentSlipRepository paymentSlipRepository;

    @Override
    public List<PaymentSlip> getAllPaymentSlips() {
        return paymentSlipRepository.findAll();
    }

    @Override
    public PaymentSlip getPaymentSlipById(Long id) {
        return paymentSlipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu chi có id: " + id));
    }

    @Override
    public PaymentSlip addPaymentSlip(PaymentSlip paymentSlip) {
        if (paymentSlip.getCreatedAt() == null) {
            paymentSlip.setCreatedAt(LocalDateTime.now());
        }
        return paymentSlipRepository.save(paymentSlip);
    }
}
