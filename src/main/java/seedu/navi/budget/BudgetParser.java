package seedu.navi.budget;
import seedu.navi.textui.NaviTextUi;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Handles user interactions for the Budget module, parsing and executing commands.
 */
public class BudgetParser {
    private static seedu.navi.budget.Budget budget;
    private static Scanner scanner;

    public BudgetParser(seedu.navi.budget.Budget budget) {
        BudgetParser.budget = budget;
    }

    /**
     * Starts the Budget command-line interface loop.
     */
    public void start() {
        scanner = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        LocalDate lastUpdated = budget.getLastUpdatedDate();

        if ((lastUpdated!=null) && (budget.isNewWeek(lastUpdated, today))) {
            NaviTextUi.printLineSeparator();
            System.out.println("Do you want to carry over last week's remaining budget of $" + String.format("%.2f",
                    budget.getWeeklyBudget()) + "? (yes/no)");
            NaviTextUi.printLineSeparator();
            System.out.print("> ");
            String response = scanner.nextLine().trim().toLowerCase();
            while (!response.equals("yes") && !response.equals("no")) {
                NaviTextUi.printLineSeparator();
                System.out.println("Please enter 'yes' or 'no'.");
                NaviTextUi.printLineSeparator();
                System.out.print("> ");
                response = scanner.nextLine().trim().toLowerCase();
            }
            budget.resetWeeklyBudget(response.equals("yes"));
        }

        budget.resetIfNeeded(); // Check if a reset is needed (daily, weekly, monthly)

        NaviTextUi.printLineSeparator();
        System.out.println("Budget Tracker: Enter a command (add X, deduct X, view, exit)");
        NaviTextUi.printLineSeparator();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                NaviTextUi.printLineSeparator();
                System.out.println("Please enter a command (add X, deduct X, view, exit)");
                NaviTextUi.printLineSeparator();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            double amount = 0;
            boolean isAddOrDeduct = command.equals("add") || command.equals("deduct");

            if (isAddOrDeduct) {
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    NaviTextUi.printLineSeparator();
                    System.out.println("Please enter an amount after the command.");
                    NaviTextUi.printLineSeparator();
                    continue;
                }

                String amountStr = parts[1].trim();

                try {
                    amount = Double.parseDouble(amountStr);
                    if (Double.isInfinite(amount) || Double.isNaN(amount)) {
                        throw new ArithmeticException("Amount is too large or invalid.");
                    }
                    if (amount < 0) {
                        NaviTextUi.printLineSeparator();
                        System.out.println("Please enter a positive number.");
                        NaviTextUi.printLineSeparator();
                        continue;
                    }
                } catch (NumberFormatException e) {
                    NaviTextUi.printLineSeparator();
                    System.out.println("Please enter a valid number.");
                    NaviTextUi.printLineSeparator();
                    continue;
                } catch (ArithmeticException e) {
                    NaviTextUi.printLineSeparator();
                    System.out.println("Amount is too large to be processed.");
                    NaviTextUi.printLineSeparator();
                    continue;
                }
            }


            switch (command) {
            case "add":
                try {
                    budget.addWeeklyBudget(amount);
                } catch (IllegalArgumentException e) {
                    NaviTextUi.printLineSeparator();
                    System.out.println("Error: " + e.getMessage());
                    NaviTextUi.printLineSeparator();
                }
                break;
            case "deduct":
                try {
                    budget.deductExpense(amount);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    NaviTextUi.printLineSeparator();
                    System.out.println("Error: " + e.getMessage());
                    NaviTextUi.printLineSeparator();
                }
                break;
            case "view":
                budget.viewExpenses();
                break;
            case "reset":
                budget.resetWeeklyBudget(false); // Reset weekly budget (user chooses whether to carry over)
                break;
            case "exit":
                NaviTextUi.printLineSeparator();
                System.out.println("Exiting Budget Tracker.");
                NaviTextUi.printLineSeparator();
                return;
            default:
                NaviTextUi.printLineSeparator();
                System.out.println("Unknown command. Try: add X, deduct X, view, exit.");
                NaviTextUi.printLineSeparator();
            }
        }
    }
}
