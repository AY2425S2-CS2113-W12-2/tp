package seedu.navi;

import seedu.navi.budget.BudgetParser;
import seedu.navi.canteen.CanteenMain;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.favorites.FavoritesParser;
import seedu.navi.textui.TextUi;

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
                BudgetParser.start();
                break;
            case "favorites":
                FavoritesParser.start();
                break;
            default:
                TextUi.printInvalidCommand();
            }
        }
    }
}
