package com.tmt.paymentmanagement.command;

import com.tmt.paymentmanagement.entity.Payment;
import com.tmt.paymentmanagement.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PaymentManagerImpl implements PaymentManager {

    private final PaymentRepository paymentRepository;

    public PaymentManagerImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> create(Payment entity) {

        return Optional.of(paymentRepository.save(entity));
    }

    @Override
    public Stream<Payment> list() {
        return paymentRepository.findAll().stream();
    }

    @Override
    public Optional<Payment> forId(int id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Optional<Payment> update(int id, Payment payment) {
        paymentRepository.findById(id).ifPresent(paymentResult -> {
            paymentResult.setDescription(payment.getDescription());
            paymentResult.setCode(payment.getCode());
            paymentResult.setDays(payment.getDays());
            paymentResult.setRemindBeforeDays(payment.getRemindBeforeDays());
            paymentRepository.save(paymentResult);
        });
        return paymentRepository.findById(id);
    }

    @Override
    public Optional<Integer> delete(int id) {
        if (paymentRepository.findById(id).isPresent()) {
            paymentRepository.deleteById(id);
            return Optional.of(id);
        }
        return Optional.empty();
    }

    }
