package seedu.navi.budget;
import seedu.navi.textui.TextUi;

import java.time.LocalDate;
import java.util.Scanner;

public class BudgetParser {
    private static seedu.navi.budget.Budget budget;
    private static Scanner scanner;

    public BudgetParser(seedu.navi.budget.Budget budget) {
        BudgetParser.budget = budget;
    }

    public static void start() {
        scanner = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        LocalDate lastUpdated = budget.getLastUpdatedDate();

        if ((lastUpdated!=null) && (budget.isNewWeek(lastUpdated, today))) {
            TextUi.printLineSeparator();
            System.out.println("Do you want to carry over last week's remaining budget of $" + String.format("%.2f",
                    budget.getWeeklyBudget()) + "? (yes/no)");
            TextUi.printLineSeparator();
            System.out.print("> ");
            String response = scanner.nextLine().trim().toLowerCase();
            while (!response.equals("yes") && !response.equals("no")) {
                TextUi.printLineSeparator();
                System.out.println("Please enter 'yes' or 'no'.");
                TextUi.printLineSeparator();
                System.out.print("> ");
                response = scanner.nextLine().trim().toLowerCase();
            }
            budget.resetWeeklyBudget(response.equals("yes"));
        }

        budget.resetIfNeeded(); // Check if a reset is needed (daily, weekly, monthly)

        TextUi.printLineSeparator();
        System.out.println("Budget Tracker: Enter a command (add X, deduct X, view, exit)");
        TextUi.printLineSeparator();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                TextUi.printLineSeparator();
                System.out.println("Please enter a command (add X, deduct X, view, exit)");
                TextUi.printLineSeparator();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            double amount = 0;
            boolean isAddOrDeduct = command.equals("add") || command.equals("deduct");

            if (isAddOrDeduct) {
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    TextUi.printLineSeparator();
                    System.out.println("Please enter an amount after the command.");
                    TextUi.printLineSeparator();
                    continue;
                }

                String amountStr = parts[1].trim();

                try {
                    amount = Double.parseDouble(amountStr);
                    if (Double.isInfinite(amount) || Double.isNaN(amount)) {
                        throw new ArithmeticException("Amount is too large or invalid.");
                    }
                    if (amount < 0) {
                        TextUi.printLineSeparator();
                        System.out.println("Please enter a positive number.");
                        TextUi.printLineSeparator();
                        continue;
                    }
                } catch (NumberFormatException e) {
                    TextUi.printLineSeparator();
                    System.out.println("Please enter a valid number.");
                    TextUi.printLineSeparator();
                    continue;
                } catch (ArithmeticException e) {
                    TextUi.printLineSeparator();
                    System.out.println("Amount is too large to be processed.");
                    TextUi.printLineSeparator();
                    continue;
                }
            }


            switch (command) {
            case "add":
                try {
                    budget.addWeeklyBudget(amount);
                } catch (IllegalArgumentException e) {
                    TextUi.printLineSeparator();
                    System.out.println("Error: " + e.getMessage());
                    TextUi.printLineSeparator();
                }
                break;
            case "deduct":
                try {
                    budget.deductExpense(amount);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    TextUi.printLineSeparator();
                    System.out.println("Error: " + e.getMessage());
                    TextUi.printLineSeparator();
                }
                break;
            case "view":
                budget.viewExpenses();
                break;
            case "reset":
                budget.resetWeeklyBudget(false); // Reset weekly budget (user chooses whether to carry over)
                break;
            case "exit":
                TextUi.printLineSeparator();
                System.out.println("Exiting Budget Tracker.");
                TextUi.printLineSeparator();
                return;
            default:
                TextUi.printLineSeparator();
                System.out.println("Unknown command. Try: add X, deduct X, view, exit.");
                TextUi.printLineSeparator();
            }
        }
    }
}
