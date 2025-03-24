package seedu.navi.budget;
import seedu.navi.textui.TextUi;

import java.text.DecimalFormat;

public class Budget {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private double dailyBudget;   // Money available for today
    private double monthlyTotal;  // Total spent this month
    private double dailyExpenses;

    public Budget() {
        this.dailyBudget = 0.0;
        this.monthlyTotal = 0.0;
        this.dailyExpenses = 0.0;

    }

    // Sets the daily budget
    public void addDailyBudget(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }

        dailyBudget += amount;
        TextUi.printLineSeparator();
        System.out.println("Added $" + df.format(amount) + " to today's budget.");
        System.out.println("📌 Remaining daily budget: $" + df.format(dailyBudget));
        TextUi.printLineSeparator();
    }

    // Deducts money from daily budget, records daily expenses, and adds to monthly spending
    public void deductExpense(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }
        if (dailyBudget < amount) {
            throw new IllegalStateException("You cannot deduct more than your current daily budget.");
        }

        dailyBudget -= amount;
        dailyExpenses += amount;
        monthlyTotal += amount;

        TextUi.printLineSeparator();
        System.out.println("Deducted $" + df.format(amount) + " from your daily budget.");
        System.out.println("📌 Remaining daily budget: $" + df.format(dailyBudget));
        TextUi.printLineSeparator();
    }

    // Views remaining daily budget & total spent this month
    public void viewExpenses() {
        TextUi.printLineSeparator();
        System.out.println("📌 Remaining daily budget: $" + df.format(dailyBudget));
        System.out.println("📆 Total spent today: $" + df.format(dailyExpenses));
        System.out.println("📅 Total spent this month: $" + df.format(monthlyTotal));
        TextUi.printLineSeparator();
    }

    // Getter methods to allow access to private fields
    public double getDailyBudget() {
        assert dailyBudget >= 0 : "Daily budget should never be negative";
        return dailyBudget;
    }

    public double getDailyExpenses() {
        assert dailyExpenses >= 0 : "Daily expenses should never be negative";
        return dailyExpenses;
    }

    public double getMonthlyTotal() {
        assert monthlyTotal >= 0 : "Monthly total should never be negative";
        return monthlyTotal;
    }
}

