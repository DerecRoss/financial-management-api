package com.gestao_financeira.web.controller;

import com.gestao_financeira.web.controller.docs.PaymentControllerDocs;
import com.gestao_financeira.web.dto.DashboardResponse;
import com.gestao_financeira.web.dto.MonthlyHistoryResponse;
import com.gestao_financeira.web.dto.PaymentResponse;
import com.gestao_financeira.web.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Tag(name = "Payments", description = "Endpoint for manage payments by team")
public class PaymentController implements PaymentControllerDocs {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/generate")
    @Override
    public ResponseEntity<Void> generateMonthlyPayments() {
        paymentService.generateMonthlyPayments();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/current-month")
    @Override
    public ResponseEntity<List<PaymentResponse>> findCurrentMonth() {

        List<PaymentResponse> payments =
                paymentService.findCurrentMonth();

        return ResponseEntity.ok(payments);
    }

    @GetMapping("/dashboard")
    @Override
    public ResponseEntity<DashboardResponse> getDashboard() {

        DashboardResponse dashboard = paymentService.getDashboard();

        return ResponseEntity.ok(dashboard);
    }

    @GetMapping("/status/{paid}")
    @Override
    public ResponseEntity<List<PaymentResponse>> findByStatus(@PathVariable Boolean paid) {
        return ResponseEntity.ok(
                paymentService.findByStatus(paid)
        );
    }

    @GetMapping("/search")
    @Override
    public ResponseEntity<List<PaymentResponse>> searchByName(
            @RequestParam String name) {

        return ResponseEntity.ok(
                paymentService.searchByName(name)
        );
    }

    @PatchMapping("/{id}/pay")
    @Override
    public ResponseEntity<PaymentResponse> pay(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.pay(id));
    }

    @PatchMapping("/{id}/unpay")
    @Override
    public ResponseEntity<PaymentResponse> unpay(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.unpay(id));
    }

    @GetMapping("/history")
    @Override
    public ResponseEntity<List<MonthlyHistoryResponse>> getHistory(
            @RequestParam Integer year) {

        return ResponseEntity.ok(
                paymentService.getHistory(year)
        );
    }

    @GetMapping("/month/{year}/{month}")
    @Override
    public ResponseEntity<List<PaymentResponse>> findByMonthAndYear(
            @PathVariable Integer year,
            @PathVariable Integer month
    ) {

        return ResponseEntity.ok(
                paymentService.findByMonthAndYear(month, year)
        );
    }
}
