package com.gestao_financeira.web.service;

import com.gestao_financeira.web.dto.DashboardResponse;
import com.gestao_financeira.web.dto.MonthlyHistoryResponse;
import com.gestao_financeira.web.dto.PaymentResponse;
import com.gestao_financeira.web.model.Payment;
import com.gestao_financeira.web.model.Person;
import com.gestao_financeira.web.repository.PaymentRepository;
import com.gestao_financeira.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Scheduled(cron = "0 0 0 1 * *")
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

    @EventListener(ApplicationReadyEvent.class)
    public void generatePaymentsOnStartup() {
        generateMonthlyPayments();
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

    public PaymentResponse pay(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (!Boolean.TRUE.equals(payment.getPaid())) {
            payment.setPaid(true);
            payment.setPaidAt(LocalDate.now());
        }

        return convertToResponse(paymentRepository.save(payment));
    }

    public PaymentResponse unpay(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaid(false);
        payment.setPaidAt(null);

        return convertToResponse(paymentRepository.save(payment));
    }

    public List<MonthlyHistoryResponse> getHistory(Integer year) {

        List<Payment> payments =
                paymentRepository.findByYearOrderByMonthDesc(year);

        return payments.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        payment -> payment.getMonth()
                ))
                .entrySet()
                .stream()
                .map(entry -> {

                    Integer month = entry.getKey();

                    List<Payment> monthlyPayments = entry.getValue();

                    int totalPeople = monthlyPayments.size();

                    int paidPeople = (int) monthlyPayments.stream()
                            .filter(payment ->
                                    Boolean.TRUE.equals(payment.getPaid()))
                            .count();

                    int pendingPeople = totalPeople - paidPeople;

                    int totalExpected = monthlyPayments.stream()
                            .mapToInt(Payment::getAmount)
                            .sum();

                    int totalReceived = monthlyPayments.stream()
                            .filter(payment ->
                                    Boolean.TRUE.equals(payment.getPaid()))
                            .mapToInt(Payment::getAmount)
                            .sum();

                    int totalPending = totalExpected - totalReceived;

                    MonthlyHistoryResponse response =
                            new MonthlyHistoryResponse();

                    response.setMonth(month);
                    response.setYear(year);
                    response.setTotalPeople(totalPeople);
                    response.setPaidPeople(paidPeople);
                    response.setPendingPeople(pendingPeople);
                    response.setTotalExpected(totalExpected);
                    response.setTotalReceived(totalReceived);
                    response.setTotalPending(totalPending);

                    return response;
                })
                .toList();
    }

    public List<PaymentResponse> findByMonthAndYear(
            Integer month,
            Integer year
    ) {

        List<Payment> payments =
                paymentRepository.findByMonthAndYearOrderByIdAsc(
                        month,
                        year
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
