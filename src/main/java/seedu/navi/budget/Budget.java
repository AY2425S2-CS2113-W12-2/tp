package seedu.navi.budget;
import seedu.navi.textui.TextUi;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;

/**
 * Handles budgeting operations including tracking weekly, daily, and monthly expenses.
 */
public class Budget {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static String filePath = "budget_data.json";

    private double weeklyBudget;   // Money available for today
    private double monthlyExpenses;  // Total spent this month
    private double weeklyExpenses;
    private double dailyExpenses;
    private LocalDate lastUpdatedDate;
    private LocalDate currentDateForTesting; // Add this field

    /**
     * Constructor that loads budget data from file.
     */
    public Budget() {
        loadBudgetData();
    }

    /**
     * Sets a custom file path for storing budget data.
     * @param path Path to data file
     */
    public static void setFilePath(String path) {
        filePath = path;
    }

    /**
     * Resets expenses if the date has changed (new day, new week, or new month).
     */
    public void resetIfNeeded() {
        LocalDate today = getCurrentDate();
        if (lastUpdatedDate == null || isNewWeek(lastUpdatedDate, today)) {
            weeklyExpenses = 0; // Reset weekly expenses
        }
        if (lastUpdatedDate == null || !today.equals(lastUpdatedDate)) {
            if (lastUpdatedDate == null || !today.getMonth().equals(lastUpdatedDate.getMonth())) {
                monthlyExpenses = 0; // Reset monthly spending
            }
            dailyExpenses = 0; // Reset daily expenses
            lastUpdatedDate = today;
            saveBudgetData();
        }
    }

    /**
     * Resets the weekly budget.
     * @param carryOver Whether to carry over remaining budget from the previous week
     */
    public void resetWeeklyBudget(boolean carryOver) {
        if (!carryOver) {
            weeklyBudget = 0;
        }
        saveBudgetData();
    }

    /**
     * Adds money to the weekly budget.
     * @param amount Amount to add
     */
    public void addWeeklyBudget(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }
        weeklyBudget += amount;
        saveBudgetData();
        TextUi.printLineSeparator();
        System.out.println("Added $" + df.format(amount) + " to this week's budget.");
        System.out.println("Remaining weekly budget: $" + df.format(weeklyBudget));
        TextUi.printLineSeparator();
    }

    /**
     * Deducts an expense from the weekly budget and updates all related expense records.
     * @param amount Amount to deduct
     */
    public void deductExpense(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount. Please enter a positive value.");
        }
        if (weeklyBudget < amount) {
            throw new IllegalStateException("You cannot deduct more than your current weekly budget.");
        }

        weeklyBudget -= amount;
        dailyExpenses += amount;
        weeklyExpenses += amount;
        monthlyExpenses += amount;
        saveBudgetData();

        TextUi.printLineSeparator();
        System.out.println("Deducted $" + df.format(amount) + " from your weekly budget.");
        System.out.println("Remaining weekly budget: $" + df.format(weeklyBudget));
        TextUi.printLineSeparator();
    }

    /**
     * Displays the current budget and expenses.
     */
    public void viewExpenses() {
        TextUi.printLineSeparator();
        System.out.println("Remaining weekly budget: $" + df.format(weeklyBudget));
        System.out.println("Total spent today: $" + df.format(dailyExpenses));
        System.out.println("Total spent this week: $" + df.format(weeklyExpenses));
        System.out.println("Total spent this month: $" + df.format(monthlyExpenses));
        TextUi.printLineSeparator();
    }

    /**
     * Saves budget data to the file.
     */
    private void saveBudgetData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            HashMap<String, String> data = new HashMap<>();
            data.put("weeklyBudget", String.valueOf(weeklyBudget));
            data.put("dailyExpenses", String.valueOf(dailyExpenses));
            data.put("weeklyTotal", String.valueOf(weeklyExpenses));
            data.put("monthlyTotal", String.valueOf(monthlyExpenses));
            data.put("lastUpdatedDate", lastUpdatedDate.toString());
            writer.write(data.toString());
        } catch (IOException e) {
            System.err.println("Error saving budget data: " + e.getMessage());
        }
    }

    /**
     * Loads budget data from the file.
     */
    private void loadBudgetData() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line == null) {
                return;
            }
            line = line.replaceAll("[{} ]", "");
            String[] entries = line.split(",");
            for (String entry : entries) {
                String[] keyValue = entry.split("=");
                if (keyValue.length < 2) {
                    continue;
                }
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                case "weeklyBudget" -> weeklyBudget = Double.parseDouble(value);
                case "dailyExpenses" -> dailyExpenses = Double.parseDouble(value);
                case "weeklyTotal" -> weeklyExpenses = Double.parseDouble(value);
                case "monthlyTotal" -> monthlyExpenses = Double.parseDouble(value);
                case "lastUpdatedDate" -> lastUpdatedDate = LocalDate.parse(value);
                default -> throw new IllegalArgumentException("Invalid key: " + key);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading budget data: " + e.getMessage());
        }
    }

    // Getter methods to allow access to private fields
    public double getWeeklyBudget() {
        assert weeklyBudget >= 0 : "Weekly budget should never be negative";
        return weeklyBudget;
    }

    public double getDailyExpenses() {
        assert dailyExpenses >= 0 : "Daily expenses should never be negative";
        return dailyExpenses;
    }

    public double getMonthlyExpenses() {
        assert monthlyExpenses >= 0 : "Monthly total should never be negative";
        return monthlyExpenses;
    }

    public double getWeeklyExpenses() {
        assert weeklyExpenses >= 0 : "Weekly budget should never be negative";
        return weeklyExpenses;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     * Sets the last updated date (for testing and initialization).
     * @param lastUpdatedDate The last updated date
     */
    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }


    /**
     * Checks if the current date belongs to a new week.
     * @param lastUpdatedDate The last updated date
     * @param today Current date
     * @return true if new week, false otherwise
     */
    public boolean isNewWeek(LocalDate lastUpdatedDate, LocalDate today) {
        if (lastUpdatedDate == null) {
            return true;
        }
        int currentWeek = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        int lastWeek = lastUpdatedDate.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        return currentWeek != lastWeek || today.getYear() != lastUpdatedDate.getYear();
    }

    /**
     * Sets the current date (for testing purposes).
     * @param date Test date
     */
    public void setCurrentDateForTesting(LocalDate date) {
        this.currentDateForTesting = date;
    }

    private LocalDate getCurrentDate() {
        return currentDateForTesting != null ? currentDateForTesting : LocalDate.now();
    }

    /**
     * Clears the test date and reverts to system date.
     */
    public void clearTestDate() {
        this.currentDateForTesting = null;
    }
}
