package seedu.navi;

import seedu.navi.budget.Budget;
import seedu.navi.budget.BudgetParser;
import seedu.navi.canteen.CanteenMain;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.favorites.Favorites;
import seedu.navi.favorites.FavoritesParser;
import seedu.navi.textui.TextUi;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        Storage.processDataFromFiles();

        TextUi.printGreeting();
        Scanner in = new Scanner(System.in);

        // instantiate Budget and BudgetParser once
        Budget budget = new Budget();
        BudgetParser budgetParser = new BudgetParser(budget);

        // instantiate Favorites and FavoritesParser once
        Favorites favorites = new Favorites();
        FavoritesParser favoritesParser = new FavoritesParser(favorites);

        while (true) {
            String input = in.nextLine().toLowerCase().trim();
            switch (input) {
            case "exit":
            case "e":
                TextUi.printExitMessage();
                System.exit(0);
                break;
            case "canteen":
            case "c":
                CanteenMain.startCanteen();
                break;
            case "budget":
                budgetParser.start();
                break;
            case "favorites":
                favoritesParser.start();
                break;
            default:
                TextUi.printInvalidCommand();
            }
        }
    }
}

