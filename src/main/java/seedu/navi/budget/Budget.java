package seedu.navi.budget;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Budget {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final Logger logger = Logger.getLogger(Budget.class.getName());

    private double dailyBudget;   // Money available for today
    private double monthlyTotal;  // Total spent this month
    private double dailyExpenses;

    public Budget() {
        this.dailyBudget = 0.0;
        this.monthlyTotal = 0.0;
        this.dailyExpenses = 0.0;

        logger.log(Level.INFO, "Budget initialized with default values.");
    }

    // Sets the daily budget
    public void addDailyBudget(double amount) {

        if (amount < 0) {
            logger.log(Level.WARNING, "Attempted to add negative amount to budget: {0}", amount);
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }

        dailyBudget += amount;
        logger.log(Level.INFO, "Added ${0} to today's budget. New daily budget: ${1}", new Object[]{df.format(amount), df.format(dailyBudget)});
    }

    // Deducts money from daily budget, records daily expenses, and adds to monthly spending
    public void deductExpense(double amount) {

        if (amount < 0) {
            logger.log(Level.WARNING, "Attempted to deduct negative amount: {0}", amount);
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }
        if (dailyBudget < amount) {
            logger.log(Level.WARNING, "Insufficient budget: Tried to deduct {0}, but only {1} available", new Object[]{df.format(amount), df.format(dailyBudget)});
            throw new IllegalStateException("Error: You cannot deduct more than your current daily budget.");
        }

        dailyBudget -= amount;
        dailyExpenses += amount;
        monthlyTotal += amount;

        logger.log(Level.INFO, "Deducted ${0} from daily budget. Remaining: ${1}", new Object[]{df.format(amount), df.format(dailyBudget)});
        logger.log(Level.INFO, "📆 Total spent today: ${0}, 📅 Total spent this month: ${1}", new Object[]{df.format(dailyExpenses), df.format(monthlyTotal)});
    }

    // Views remaining daily budget & total spent this month
    public void viewExpenses() {
        logger.log(Level.INFO, "Viewing expenses: Daily budget: ${0}, Total spent today: ${1}, Total spent this month: ${2}",
                new Object[]{df.format(dailyBudget), df.format(dailyExpenses), df.format(monthlyTotal)});

        System.out.println("📌 Remaining daily budget: $" + df.format(dailyBudget));
        System.out.println("📆 Total spent today: $" + df.format(dailyExpenses));
        System.out.println("📅 Total spent this month: $" + df.format(monthlyTotal));
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

