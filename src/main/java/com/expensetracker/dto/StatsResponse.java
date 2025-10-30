package com.expensetracker.dto;

public class StatsResponse {

    private Double totalExpenses;
    private Double thisMonthTotal;
    private Double averageExpense;
    private Long totalTransactions;

    // Constructors
    public StatsResponse() {
    }

    public StatsResponse(Double totalExpenses, Double thisMonthTotal, Double averageExpense, Long totalTransactions) {
        this.totalExpenses = totalExpenses;
        this.thisMonthTotal = thisMonthTotal;
        this.averageExpense = averageExpense;
        this.totalTransactions = totalTransactions;
    }

    // Getters and Setters
    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getThisMonthTotal() {
        return thisMonthTotal;
    }

    public void setThisMonthTotal(Double thisMonthTotal) {
        this.thisMonthTotal = thisMonthTotal;
    }

    public Double getAverageExpense() {
        return averageExpense;
    }

    public void setAverageExpense(Double averageExpense) {
        this.averageExpense = averageExpense;
    }

    public Long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
