package com.bybills;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String billName;
    private double amount;
    private LocalDate dueDate;

    public Bill() {}

    public Long getId() {
        return id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Optional helper method
    @Transient
    public String getStatus() {

        LocalDate today = LocalDate.now();

        if (dueDate.isBefore(today)) {
            return "OVERDUE";
        }

        if (dueDate.isEqual(today)) {
            return "TODAY";
        }

        return "UPCOMING";
    }
}