package com.darla.util;

import java.time.LocalDate;

import com.darla.enums.TransactionType;

public class Transaction {
	TransactionType type;
    double amount;
    String category;
    LocalDate date;

    public Transaction(TransactionType type, double amount, String category, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + "," + amount + "," + category + "," + date;
    }
}
