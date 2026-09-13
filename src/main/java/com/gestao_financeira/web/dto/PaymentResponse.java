package com.gestao_financeira.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class PaymentResponse {

    @Schema(description = "Identifier of Person", example = "1")
    private Long id;

    @Schema(description = "Person identifier")
    private Long personId;

    @Schema(description = "Name of user", example = "Tulio Zynga")
    private String name;

    @Schema(description = "Number of user", example = "15998977910")
    private String number;

    @Schema(description = "Amount of total users")
    private Integer amount;

    @Schema(description = "Day of payment for month")
    private Integer dayOfPayment;

    @Schema(description = "Payment of user", example = "true")
    private Boolean paid;

    @Schema(description = "Payment at date by user", example = "2026-05-05")
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
