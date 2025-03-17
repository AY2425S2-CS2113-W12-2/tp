package seedu.navi.budget;
import java.text.DecimalFormat;

public class Budget {
    private double dailyBudget;   // Money available for today
    private double monthlyTotal;  // Total spent this month
    private double dailyExpenses;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Budget() {
        this.dailyBudget = 0.0;
        this.monthlyTotal = 0.0;
        this.dailyExpenses = 0.0;
    }

    // Sets the daily budget
    public void addDailyBudget(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        dailyBudget += amount;
        System.out.println("Added $" + df.format(amount) + " to today's budget.");
    }

    // Deducts money from daily budget, records daily expenses, and adds to monthly spending
    public void deductExpense(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (dailyBudget < amount) {
            System.out.println("Error: You cannot deduct more than your current daily budget.");
            return;
        }
        dailyBudget -= amount;
        dailyExpenses += amount;
        monthlyTotal += amount;

        System.out.println("Deducted $" + df.format(amount) + " from your daily budget.");
        System.out.println("📆 Total spent today: $" + df.format(dailyExpenses));
        System.out.println("📅 Total spent this month: $" + df.format(monthlyTotal));
    }

    // Views remaining daily budget & total spent this month
    public void viewExpenses() {
        System.out.println("📌 Remaining daily budget: $" + df.format(dailyBudget));
        System.out.println("📆 Total spent today: $" + df.format(dailyExpenses));
        System.out.println("📅 Total spent this month: $" + df.format(monthlyTotal));
    }

}
