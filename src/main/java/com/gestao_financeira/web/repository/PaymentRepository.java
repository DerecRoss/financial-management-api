package com.gestao_financeira.web.repository;

import com.gestao_financeira.web.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByMonthAndYear(Integer month, Integer year);

    List<Payment> findByMonthAndYearAndPaid(
            Integer month,
            Integer year,
            Boolean paid
    );

    List<Payment> findByYearOrderByMonthDesc(Integer year);

    List<Payment> findByMonthAndYearOrderByIdAsc(
            Integer month,
            Integer year
    );

    List<Payment> findByMonthAndYearAndPersonNameContainingIgnoreCase(
            Integer month,
            Integer year,
            String name
    );

    Optional<Payment> findByPersonIdAndMonthAndYear(
            Long personId,
            Integer month,
            Integer year
    );
}
