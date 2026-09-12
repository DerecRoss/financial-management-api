package com.gestao_financeira.web.dto;

public class PersonPaymentResponse {
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
