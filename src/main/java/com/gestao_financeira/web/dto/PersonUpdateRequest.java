package com.gestao_financeira.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class PersonUpdateRequest {

    @NotBlank(message = "name can't be null")
    private String name;

    @NotBlank(message = "number can't be null")
    private String number;

    @NotNull(message = "Day of payment is obligatory")
    @Min(value = 1)
    @Max(value = 31)
    private Integer dayOfPayment;

    @NotNull(message = "monthly of payment can't be null")
    @Min(value = 0, message = "value can't be null")
    private Integer monthlyPayment;

    public PersonUpdateRequest() {
    }

    public PersonUpdateRequest(String name, String number, Integer dayOfPayment, Integer monthlyPayment) {
        this.name = name;
        this.number = number;
        this.dayOfPayment = dayOfPayment;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "PersonUpdateRequest{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", dayOfPayment=" + dayOfPayment +
                ", monthlyPayment=" + monthlyPayment +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonUpdateRequest that = (PersonUpdateRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number) && Objects.equals(dayOfPayment, that.dayOfPayment) && Objects.equals(monthlyPayment, that.monthlyPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, dayOfPayment, monthlyPayment);
    }
}
