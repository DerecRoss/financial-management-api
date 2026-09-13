package com.gestao_financeira.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class MonthlyHistoryResponse {

    @Schema(description = "Currently month")
    private Integer month;

    @Schema(description = "Currently year")
    private Integer year;

    @Schema(description = "Total people of team")
    private Integer totalPeople;

    @Schema(description = "Total people paid")
    private Integer paidPeople;

    @Schema(description = "Total people pending paid")
    private Integer pendingPeople;

    @Schema(description = "Total amount expected")
    private Integer totalExpected;

    @Schema(description = "Total amount received")
    private Integer totalReceived;

    @Schema(description = "Total amount pending")
    private Integer totalPending;

    public MonthlyHistoryResponse() {
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Integer totalPeople) {
        this.totalPeople = totalPeople;
    }

    public Integer getPaidPeople() {
        return paidPeople;
    }

    public void setPaidPeople(Integer paidPeople) {
        this.paidPeople = paidPeople;
    }

    public Integer getPendingPeople() {
        return pendingPeople;
    }

    public void setPendingPeople(Integer pendingPeople) {
        this.pendingPeople = pendingPeople;
    }

    public Integer getTotalExpected() {
        return totalExpected;
    }

    public void setTotalExpected(Integer totalExpected) {
        this.totalExpected = totalExpected;
    }

    public Integer getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(Integer totalReceived) {
        this.totalReceived = totalReceived;
    }

    public Integer getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(Integer totalPending) {
        this.totalPending = totalPending;
    }
}