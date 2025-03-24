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
        budget.resetIfNeeded(); // Check if a reset is needed (daily, weekly, monthly)

        TextUi.printLineSeparator();
        System.out.println("💰 Budget Tracker: Enter a command (add X, deduct X, view, exit)");
        TextUi.printLineSeparator();

        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek().getValue() == 1) { // Monday
            System.out.println("Do you want to carry over last week's remaining budget? (yes/no)");
            System.out.print("> ");
            String response = scanner.nextLine().trim().toLowerCase();
            budget.resetWeeklyBudget(response.equals("yes"));
        }


        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                TextUi.printLineSeparator();
                System.out.println("⚠️ Please enter a command.");
                TextUi.printLineSeparator();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            double amount = 0;

            if (parts.length > 1) {
                try {
                    amount = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    TextUi.printLineSeparator();
                    System.out.println("⚠️ Invalid number format. Please enter a valid amount.");
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
                    System.out.println("⚠ Error: " + e.getMessage());
                    TextUi.printLineSeparator();
                }
                break;
            case "deduct":
                try {
                    budget.deductExpense(amount);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    TextUi.printLineSeparator();
                    System.out.println("⚠ Error: " + e.getMessage());
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
                System.out.println("👋 Exiting Budget Tracker.");
                TextUi.printLineSeparator();
                return;
            default:
                TextUi.printLineSeparator();
                System.out.println("⚠️ Unknown command. Try: add X, deduct X, view, exit.");
                TextUi.printLineSeparator();
            }
        }
    }
}



