package com.tmt.paymentmanagement.controller;

import com.tmt.paymentmanagement.command.PaymentManager;
import com.tmt.paymentmanagement.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentManager paymentManager;

    @Autowired
    public PaymentController(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return paymentManager.create(payment).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<Payment>> list() {
        return Optional.of(paymentManager.list().collect(Collectors.toList())).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable("id") int id) {
        return paymentManager.forId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable("id") int id, @RequestBody Payment payment) {
        return paymentManager.update(id, payment).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return paymentManager.delete(id).map(x -> ResponseEntity.noContent().build()).orElse(ResponseEntity.notFound().build());
    }
}
