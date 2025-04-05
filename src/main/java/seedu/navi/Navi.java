package seedu.navi;

import seedu.navi.canteen.Canteen;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.textui.TextUi;
import seedu.navi.budget.Budget;
import seedu.navi.budget.BudgetParser;
import seedu.navi.favorites.Favorites;
import seedu.navi.favorites.FavoritesParser;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     * @author kevinchangckc
     */
    public static void main(String[] args) {
        Storage.processDataFromFiles();

        TextUi.printGreeting();
        Scanner in = new Scanner(System.in);

        // Start command processing
        Navi ui = new Navi();
        Favorites favorites = new Favorites();
        Budget budget = new Budget();
        Parser parser = new Parser(ui, favorites, budget);

        while (true) {
            String input = in.nextLine().trim();
            parser.handleCommand(input);
        }
    }
}

/**
 * @author kevinchangckc
 */
class Parser {
    private final Favorites favorites;
    private final Budget budget;

    public Parser(Navi ui, Favorites favorites, Budget budget) {
        this.favorites = favorites;
        this.budget = budget;
    }

    /**
     * @author kevinchangckc
     */
    public void handleCommand(String input) {
        switch (input.toLowerCase()) {
        case "exit":
        case "e":
            TextUi.printExitMessage();
            System.exit(0);
            break;
        case "canteen":
        case "c":
            Canteen.startCanteen();
            break;
        case "budget":
            BudgetParser budgetParser = new BudgetParser(budget);
            budgetParser.start();
            break;
        case "favorites":
            FavoritesParser favoritesParser = new FavoritesParser(favorites);
            favoritesParser.start();
            break;
        default:
            TextUi.printInvalidCommand();
        }
    }
}
