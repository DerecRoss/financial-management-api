package com.gestao_financeira.web.service;

import com.gestao_financeira.web.dto.DashboardResponse;
import com.gestao_financeira.web.dto.PaymentResponse;
import com.gestao_financeira.web.model.Payment;
import com.gestao_financeira.web.model.Person;
import com.gestao_financeira.web.repository.PaymentRepository;
import com.gestao_financeira.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PersonRepository personRepository;

    public void generateMonthlyPayments() {

        LocalDate today = LocalDate.now();

        Integer month = today.getMonthValue();
        Integer year = today.getYear();

        List<Person> people = personRepository.findAll();

        for (Person person : people) {

            boolean exists = paymentRepository
                    .findByPersonIdAndMonthAndYear(
                            person.getId(),
                            month,
                            year
                    )
                    .isPresent();

            if (!exists) {

                Payment payment = new Payment();

                payment.setPerson(person);
                payment.setMonth(month);
                payment.setYear(year);
                payment.setAmount(person.getMonthlyPayment());
                payment.setPaid(false);

                paymentRepository.save(payment);
            }
        }
    }

    public List<PaymentResponse> findByStatus(Boolean paid) {

        LocalDate today = LocalDate.now();

        List<Payment> payments =
                paymentRepository.findByMonthAndYearAndPaid(
                        today.getMonthValue(),
                        today.getYear(),
                        paid
                );

        return payments.stream()
                .map(this::convertToResponse)
                .toList();
    }

    public List<PaymentResponse> findCurrentMonth() {

        LocalDate today = LocalDate.now();

        List<Payment> payments =
                paymentRepository.findByMonthAndYear(
                        today.getMonthValue(),
                        today.getYear()
                );

        return payments.stream()
                .map(this::convertToResponse)
                .toList();
    }

    public DashboardResponse getDashboard() {

        LocalDate today = LocalDate.now();

        Integer month = today.getMonthValue();
        Integer year = today.getYear();

        List<Payment> payments =
                paymentRepository.findByMonthAndYear(month, year);

        int totalPeople = payments.size();

        int paidPeople = (int) payments.stream()
                .filter(payment -> Boolean.TRUE.equals(payment.getPaid()))
                .count();

        int pendingPeople = totalPeople - paidPeople;

        int totalExpected = payments.stream()
                .mapToInt(Payment::getAmount)
                .sum();

        int totalReceived = payments.stream()
                .filter(payment -> Boolean.TRUE.equals(payment.getPaid()))
                .mapToInt(Payment::getAmount)
                .sum();

        int totalPending = totalExpected - totalReceived;

        double paymentPercentage = totalPeople == 0
                ? 0
                : ((double) paidPeople / totalPeople) * 100;

        DashboardResponse response = new DashboardResponse();

        response.setTotalPeople(totalPeople);
        response.setPaidPeople(paidPeople);
        response.setPendingPeople(pendingPeople);
        response.setTotalExpected(totalExpected);
        response.setTotalReceived(totalReceived);
        response.setTotalPending(totalPending);
        response.setPaymentPercentage(paymentPercentage);

        return response;
    }

    public List<PaymentResponse> searchByName(String name) {

        LocalDate today = LocalDate.now();

        List<Payment> payments =
                paymentRepository
                        .findByMonthAndYearAndPersonNameContainingIgnoreCase(
                                today.getMonthValue(),
                                today.getYear(),
                                name
                        );

        return payments.stream()
                .map(this::convertToResponse)
                .toList();
    }

    private PaymentResponse convertToResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();

        response.setId(payment.getId());
        response.setPersonId(payment.getPerson().getId());
        response.setName(payment.getPerson().getName());
        response.setNumber(payment.getPerson().getNumber());
        response.setAmount(payment.getAmount());
        response.setDayOfPayment(payment.getPerson().getDayOfPayment());
        response.setPaid(payment.getPaid());
        response.setPaidAt(payment.getPaidAt());

        return response;
    }
}
