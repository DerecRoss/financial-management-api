package com.gestao_financeira.web.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public class PersonResponse {

    @Schema(description = "Identifier of Person", example = "1")
    private Long id;

    @Schema(description = "Name of user", example = "Tulio Zynga")
    private String name;

    @Schema(description = "Number of user", example = "15998977910")
    private String number;

    @Schema(description = "Day of payment for month")
    private Integer dayOfPayment;

    @Schema(description = "Monthly payment for user")
    private Integer monthlyPayment;

    private Boolean isPaid;

    public PersonResponse() {
    }

    public PersonResponse(Long id, String name, String number, Integer dayOfPayment, Integer monthlyPayment, Boolean isPaid) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.dayOfPayment = dayOfPayment;
        this.monthlyPayment = monthlyPayment;
        this.isPaid = isPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDayOfPayment() {
        return dayOfPayment;
    }

    public void setDayOfPayment(Integer dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
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
