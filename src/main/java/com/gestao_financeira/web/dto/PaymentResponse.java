package com.gestao_financeira.web.dto;

import java.time.LocalDate;

public class PaymentResponse {

    private Long id;
    private Long personId;
    private String name;
    private String number;
    private Integer amount;
    private Integer dayOfPayment;
    private Boolean paid;
    private LocalDate paidAt;

    public PaymentResponse() {
    }

    public PaymentResponse(Long id, Long personId, String name, String number,
                           Integer amount, Integer dayOfPayment,
                           Boolean paid, LocalDate paidAt) {
        this.id = id;
        this.personId = personId;
        this.name = name;
        this.number = number;
        this.amount = amount;
        this.dayOfPayment = dayOfPayment;
        this.paid = paid;
        this.paidAt = paidAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getDayOfPayment() {
        return dayOfPayment;
    }

    public void setDayOfPayment(Integer dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public LocalDate getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDate paidAt) {
        this.paidAt = paidAt;
    }
}
