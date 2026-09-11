package com.gestao_financeira.web.dto;

import lombok.*;

import java.util.Objects;

public class PersonCreateRequest {

    private String name;
    private String number;
    private Integer dayOfPayment;
    private Integer monthlyPayment;

    public PersonCreateRequest() {
    }

    public PersonCreateRequest(String name, String number, Integer dayOfPayment, Integer monthlyPayment) {
        this.name = name;
        this.number = number;
        this.dayOfPayment = dayOfPayment;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "PersonCreateRequest{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", dayOfPayment=" + dayOfPayment +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonCreateRequest that = (PersonCreateRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number) && Objects.equals(dayOfPayment, that.dayOfPayment) && Objects.equals(monthlyPayment, that.monthlyPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, dayOfPayment, monthlyPayment);
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
}
