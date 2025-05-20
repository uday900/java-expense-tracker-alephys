package com.darla;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import com.darla.enums.TransactionType;
import com.darla.util.TransactionManager;
import com.darla.util.Transaction;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static TransactionManager manager = new TransactionManager();
	
	public static void main(String[] args) throws IOException {
		while (true) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Load data from file");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. Save data to file");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ex: 1 or 2 or 3 ... = ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> {
                    System.out.print("Enter filename to load: ");
                    manager.loadFromFile(sc.nextLine());
                    System.out.println("Data loaded successfully.");
                }
                case 4 -> manager.showMonthlySummary();
                case 5 -> {
                    System.out.print("Enter filename to save: ");
                    manager.saveToFile(sc.nextLine());
                    System.out.println("Data saved successfully.");
                }
                case 6 -> {
                    System.out.println("Thank you for choosing us. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
	}
	
	private static void addIncome() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category (SALARY/BUSINESS): ");
        String category = sc.nextLine().toUpperCase();
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        manager.addTransaction(new Transaction(TransactionType.INCOME, amount, category, date));
        System.out.println("Income added successfully.");
    }
	
	private static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category (FOOD/RENT/TRAVEL): ");
        String category = sc.nextLine().toUpperCase();
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        manager.addTransaction(new Transaction(TransactionType.EXPENSE, amount, category, date));
        System.out.println("Expense added successfully.");
    }
}
