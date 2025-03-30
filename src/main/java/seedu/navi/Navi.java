package seedu.navi;

import seedu.navi.canteen.Canteen;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.textui.TextUi;
import seedu.navi.budget.Budget;
import seedu.navi.budget.BudgetParser;
import seedu.navi.favorites.Favorites;
import seedu.navi.favorites.FavoritesParser;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     * @author kevinchangckc
     */
    public static void main(String[] args) throws FileNotFoundException {
        Storage.processDataFromFiles();

        TextUi.printGreeting();
        Scanner in = new Scanner(System.in);
        TextUi.printGreetUser(in.nextLine());


        // Initialize canteenMap and dataProcessor
        Map<String, seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen> canteenMap = new HashMap<>();
        CanteenDataProcessor dataProcessor;

        try {
            dataProcessor = new CanteenDataProcessor(canteenMap);
            dataProcessor.processData();
        } catch (FileNotFoundException e) {
            TextUi.printCanteenDataFileNotFound();
            return; // Exit if file is not found
        }

        // Start command processing
        Navi ui = new Navi();
        Favorites favorites = new Favorites();
        Budget budget = new Budget();


        Parser parser = new Parser(ui, favorites, budget, dataProcessor);

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
    private final Navi ui;
    private final Favorites favorites;
    private final Budget budget;
    private final CanteenDataProcessor dataProcessor;

    public Parser(Navi ui, Favorites favorites, Budget budget, CanteenDataProcessor dataProcessor) {
        this.ui = ui;
        this.favorites = favorites;
        this.budget = budget;
        this.dataProcessor = dataProcessor;
    }




    /**
     * @author kevinchangckc
     */
    public void handleCommand(String input) {
        switch (input.toLowerCase()) {
        case "bye":
            TextUi.printExitMessage();
            System.exit(0);
            break;
        case "canteen":
        case "c":
            Canteen.startCanteen(dataProcessor);
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
