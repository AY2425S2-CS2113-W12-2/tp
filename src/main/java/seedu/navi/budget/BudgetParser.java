package seedu.navi.budget;
import java.util.Scanner;

public class BudgetParser {
    private static Budget budget;
    private static Scanner scanner;

    public BudgetParser(Budget budget) {
        BudgetParser.budget = budget;
    }

    public static void start() {
        scanner = new Scanner(System.in);
        System.out.println("💰 Budget Tracker: Enter a command (add X, deduct X, view, exit)");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("⚠️ Please enter a command.");
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            double amount = 0;

            if (parts.length > 1) {
                try {
                    amount = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Invalid number format. Please enter a valid amount.");
                    continue;
                }
            }

            switch (command) {
            case "add":
                budget.addDailyBudget(amount);
                break;
            case "deduct":
                budget.deductExpense(amount);
                break;
            case "view":
                budget.viewExpenses();
                break;
            case "exit":
                System.out.println("👋 Exiting Budget Tracker.");
                return;
            default:
                System.out.println("⚠️ Unknown command. Try: add X, deduct X, view, exit.");
            }
        }
    }
}


