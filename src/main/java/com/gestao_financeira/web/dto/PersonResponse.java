package com.gestao_financeira.web.dto;


public class PersonResponse {

    private Long id;
    private String name;
    private String number;
    private Integer dayOfPayment;
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
