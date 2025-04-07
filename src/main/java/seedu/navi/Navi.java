package seedu.navi;

import seedu.navi.budget.Budget;
import seedu.navi.budget.BudgetParser;
import seedu.navi.canteen.CanteenMain;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.favorites.Favorites;
import seedu.navi.favorites.FavoritesParser;
import seedu.navi.textui.NaviTextUi;

import java.util.Scanner;

/**
 * The Navi class serves as the main entry-point for the application.
 * It initializes the system, processes user input, and delegates tasks to specific modules
 * such as Budget, Favorites, and Canteen.
 */
public class Navi {
    
    /**
     * The main entry-point for the Navi application.
     * <p>
     * This method performs the following steps:
     * 1. Loads data from storage using {@link Storage#processDataFromFiles()}.
     * 2. Displays a greeting message using {@link NaviTextUi#printGreeting()}.
     * 3. Continuously prompts the user for input and processes commands as follows:
     *    - "exit" or "e": Exits the application by displaying a farewell message and terminating the program.
     *    - "canteen" or "c": Starts the Canteen feature by invoking {@link CanteenMain#startCanteen()}.
     *    - "budget": Starts the Budget feature by invoking {@link BudgetParser#start()}.
     *    - "favorites": Starts the Favorites feature by invoking {@link FavoritesParser#start()}.
     *    - Invalid commands: Displays an error message using {@link NaviTextUi#printInvalidCommand()}.
     * <p>
     * The method uses a single instance of {@link Scanner} to read user input and maintains instances of
     * {@link Budget}, {@link BudgetParser}, {@link Favorites}, and {@link FavoritesParser} for handling
     * respective features.
     *
     * @param args Command-line arguments (not used in this application).
     * @see Storage#processDataFromFiles()
     * @see NaviTextUi#printGreeting()
     * @see NaviTextUi#printExitMessage()
     * @see NaviTextUi#printInvalidCommand()
     * @see CanteenMain#startCanteen()
     * @see BudgetParser#start()
     * @see FavoritesParser#start()
     */
    public static void main(String[] args) {
        Storage.processDataFromFiles();

        NaviTextUi.printGreeting();
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
                NaviTextUi.printExitMessage();
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
                NaviTextUi.printInvalidCommand();
            }
        }
    }
}

