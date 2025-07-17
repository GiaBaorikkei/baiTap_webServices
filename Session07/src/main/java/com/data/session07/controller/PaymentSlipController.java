package com.data.session07.controller;

import com.data.session07.model.entity.PaymentSlip;
import com.data.session07.service.PaymentSlipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentslips")
@RequiredArgsConstructor
public class PaymentSlipController {

    private final PaymentSlipService paymentSlipService;

    @GetMapping
    public ResponseEntity<List<PaymentSlip>> getAllPaymentSlips() {
        return ResponseEntity.ok(paymentSlipService.getAllPaymentSlips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentSlip> getPaymentSlipById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentSlipService.getPaymentSlipById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentSlip> addPaymentSlip(@RequestBody PaymentSlip paymentSlip) {
        return ResponseEntity.ok(paymentSlipService.addPaymentSlip(paymentSlip));
    }
}

