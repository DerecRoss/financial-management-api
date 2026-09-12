package com.gestao_financeira.web.controller;

import com.gestao_financeira.web.dto.DashboardResponse;
import com.gestao_financeira.web.dto.PaymentResponse;
import com.gestao_financeira.web.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/generate")
    public ResponseEntity<Void> generateMonthlyPayments() {
        paymentService.generateMonthlyPayments();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/current-month")
    public ResponseEntity<List<PaymentResponse>> findCurrentMonth() {

        List<PaymentResponse> payments =
                paymentService.findCurrentMonth();

        return ResponseEntity.ok(payments);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResponse> getDashboard() {

        DashboardResponse dashboard = paymentService.getDashboard();

        return ResponseEntity.ok(dashboard);
    }

    @GetMapping("/status/{paid}")
    public ResponseEntity<List<PaymentResponse>> findByStatus(
            @PathVariable Boolean paid) {

        return ResponseEntity.ok(
                paymentService.findByStatus(paid)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<PaymentResponse>> searchByName(
            @RequestParam String name) {

        return ResponseEntity.ok(
                paymentService.searchByName(name)
        );
    }
}
