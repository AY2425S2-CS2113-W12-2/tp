package seedu.navi;

import seedu.navi.canteenfinder.CanteenFinder;
import seedu.navi.storage.Storage;
import seedu.navi.textui.TextUi;
import seedu.navi.budget.Budget;
import seedu.navi.budget.BudgetParser;
import seedu.navi.favorites.Favorites;
import seedu.navi.favorites.FavoritesParser;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        Storage.processDataFromFiles();

        TextUi.printGreeting();
        Scanner in = new Scanner(System.in);
        TextUi.printGreetUser(in.nextLine());



        // Start command processing
        Navi ui = new Navi();
        Favorites favorites = new Favorites();
        Budget budget = new Budget();
        Parser parser = new Parser(ui, favorites, budget);



        while (true) {
            String input = in.nextLine();
            parser.handleCommand(input);
        }
    }

    public void showExitMessage() {
        TextUi.printLineSeparator();
        System.out.println("Ahh, you’re headin’ off? No worries!");
        System.out.println("Keep on keepin’ on, and we’ll catch ya next time!");
        TextUi.printLineSeparator();
    }

    public void showError(String message) {
        TextUi.printLineSeparator();
        System.out.println("⚠ Whoops! " + message);
        System.out.println("Sorry! Please use one of these commands: canteen, budget, favourites, or guide.");
        TextUi.printLineSeparator();
    }
}

/**
 * Custom exception class for chatbot errors.
 */
class NaviException extends Exception {
    public NaviException(String message) {
        super("⚠ Oi! " + message +
                "\nLet's get this sorted, mate.");
    }
}

class Parser {
    private final Navi ui;
    private final Favorites favorites;
    private final Budget budget;

    public Parser(Navi ui, Favorites favorites, Budget budget) {
        this.ui = ui;
        this.favorites = favorites;
        this.budget = budget;
    }

    public void handleCommand(String input) {
        try {
            switch (input.toLowerCase()) {
            case "bye":
                ui.showExitMessage(); // Use instance method via object
                System.exit(0);
                break;
            case "canteen":
                CanteenFinder.startCanteenFinder();
                break;
            case "favorites":
                FavoritesParser favoritesParser = new FavoritesParser(favorites);
                favoritesParser.start();
                break;
            case "budget":
                BudgetParser budgetParser = new BudgetParser(budget);
                budgetParser.start();
                break;
            default:
                throw new NaviException("That’s not quite right, mate. Give it another shot!");
            }
        } catch (NaviException e) {
            ui.showError(e.getMessage());
        }
    }
}
