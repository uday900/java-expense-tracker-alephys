# Java Expense Tracker

This is a console-based **Java Expense Tracker** application built as part of a technical assignment for the **Java Developer position at Alephys**.

## 📌 Features

- ✅ Add **income** and **expenses**
- ✅ Categorize transactions (e.g., Salary, Rent, Travel, Food)
- ✅ View **monthly** and **yearly** summaries
- ✅ **Persist data** to file and load data from file
- ✅ Accepts batch transactions via **CSV file**

## 🧑‍💻 Technologies Used

- Java (JDK 17)
- Java I/O for file handling
- Java `LocalDate` and `YearMonth` APIs for date management
- Object-Oriented Programming (OOP) Principles

## 🗃️ File Format for Transactions
Each line in the file should follow this structure:
```

TransactionType,Amount,Category,Date

```

Example:

```

INCOME,50000,Salary,2025-05-20
EXPENSE,1500,Food,2025-05-21
EXPENSE,8000,Rent,2025-05-01

````

- `TransactionType`: INCOME or EXPENSE
- `Amount`: Any valid number
- `Category`: Any string (e.g., Travel, Business)
- `Date`: Format `YYYY-MM-DD`

## 📸 Screenshots

![Console Summary](screenshots/summary.png)
![File Input Sample](screenshots/input-file.png)


## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/java-expense-tracker.git
   cd java-expense-tracker
2. Compile the program:

   ```bash
   javac -d bin src/com/darla/*.java src/com/darla/util/*.java src/com/darla/enums/*.java
   ```

3. Run the application:

   ```bash
   java -cp bin com.darla.Main
   ```

4. Sample command-line usage:

   * Enter transaction details manually
   * Or load from file using:

     ```
     Enter filename to load transactions: data.txt
     ```

## 🗂 Project Structure

```
src/
├── com/darla/
│   └── Main.java
├── com/darla/enums/
│   └── TransactionType.java
├── com/darla/util/
│   ├── ExpenseTracker.java
│   └── Transaction.java
```

## 📈 Summary Output Sample

```
Summary for 2025-05
--------------------------
Total Income: ₹50000.0
  - Salary: ₹50000.0
Total Expense: ₹9500.0
  - Food: ₹1500.0
  - Rent: ₹8000.0
Balance: ₹40500.0
```

## 📧 Contact

For any queries or contributions, feel free to connect:

* 👨‍💻 [Uday Kiran Darla - LinkedIn](https://www.linkedin.com/in/darla-uday-kiran-18a450239)
* 📬 Email: [udaykirandarla2002@gmail.com](mailto:udaykirandarla2002@gmail.com)

--- 
