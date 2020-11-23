package com.tmt.paymentmanagement.command;

import com.tmt.paymentmanagement.entity.Payment;
import java.util.Optional;
import java.util.stream.Stream;

public interface PaymentManager {

    default Optional<Payment> create(Payment entity) {
        return Optional.empty();
    }

    default Optional<Payment> forId(int id) {
        return Optional.empty();
    }

    default Stream<Payment> list(){ return Stream.empty(); }

    default Optional<Payment> update(int id, Payment entity) {
        return Optional.empty();
    }

    default Optional<Integer> delete(int id) {
        return Optional.empty();
    }
}
