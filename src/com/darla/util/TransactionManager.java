package com.darla.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.darla.enums.TransactionType;

public class TransactionManager {
	List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;
                TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];
                LocalDate date = LocalDate.parse(parts[3]);
                transactions.add(new Transaction(type, amount, category, date));
            }
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Transaction t : transactions) {
                pw.println(t);
            }
        }
    }

    public void showMonthlySummary() {
        Map<YearMonth, List<Transaction>> grouped = new HashMap<>();
        for (Transaction t : transactions) {
            YearMonth ym = YearMonth.from(t.date);
            grouped.computeIfAbsent(ym, k -> new ArrayList<>()).add(t);
        }

        for (YearMonth ym : grouped.keySet()) {
            double totalIncome = 0, totalExpense = 0;
            Map<String, Double> incomeCategories = new HashMap<>();
            Map<String, Double> expenseCategories = new HashMap<>();

            for (Transaction t : grouped.get(ym)) {
                if (t.type == TransactionType.INCOME) {
                    totalIncome += t.amount;
                    incomeCategories.merge(t.category, t.amount, Double::sum);
                } else {
                    totalExpense += t.amount;
                    expenseCategories.merge(t.category, t.amount, Double::sum);
                }
            }

            System.out.println("\nSummary for " + ym);
            System.out.println("--------------------------");
            System.out.println("Total Income: ₹" + totalIncome);
            incomeCategories.forEach((k, v) -> System.out.println("  - " + k + ": ₹" + v));
            System.out.println("Total Expense: ₹" + totalExpense);
            expenseCategories.forEach((k, v) -> System.out.println("  - " + k + ": ₹" + v));
            System.out.println("Balance: ₹" + (totalIncome - totalExpense));
        }
    }
}
