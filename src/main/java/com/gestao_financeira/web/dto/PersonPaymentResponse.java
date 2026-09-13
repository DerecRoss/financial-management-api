package com.gestao_financeira.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PersonPaymentResponse {

    @Schema(description = "Monthly payment for user")
    private Integer monthlyPayment;

    private Boolean isPaid;

    public PersonPaymentResponse() {
    }

    public PersonPaymentResponse(Integer monthlyPayment, Boolean isPaid) {
        this.monthlyPayment = monthlyPayment;
        this.isPaid = isPaid;
    }

    public Integer getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Integer monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
