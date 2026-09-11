package com.gestao_financeira.web.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "persons_db")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "number", nullable = false, length = 30)
    private String number;

    @Column(name = "dayOfPayment", nullable = false)
    private Integer dayOfPayment;

    @Column(name = "monthlyPayment", nullable = false)
    private Integer monthlyPayment;

    @Column(name = "isPaid")
    private Boolean isPaid;

    public Person() {
    }

    public Person(Long id, String name, String number, Integer dayOfPayment, Integer monthlyPayment, Boolean isPaid) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.dayOfPayment = dayOfPayment;
        this.monthlyPayment = monthlyPayment;
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", dayOfPayment=" + dayOfPayment +
                ", monthlyPayment=" + monthlyPayment +
                ", isPaid=" + isPaid +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(number, person.number) && Objects.equals(dayOfPayment, person.dayOfPayment) && Objects.equals(monthlyPayment, person.monthlyPayment) && Objects.equals(isPaid, person.isPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, dayOfPayment, monthlyPayment, isPaid);
    }
}
