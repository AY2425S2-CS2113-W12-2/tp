package seedu.navi.canteen;

import seedu.navi.canteen.canteenfinder.CanteenFinderStartup;
import seedu.navi.canteen.canteenlookup.CanteenLookupStartup;
import seedu.navi.textui.CanteenMainTextUi;
import seedu.navi.textui.TextUi;

/**
 * The CanteenMain class serves as the entry point for the canteen-related functionalities.
 * It provides a command-driven interface for users to interact with the Canteen Finder and
 * Canteen Lookup modules. Users can choose between these modules or exit the program by entering
 * specific commands.
 * <p>
 * This class continuously prompts the user for input until they explicitly exit the program.
 *
 * @see CanteenFinderStartup#startCanteenFinder()
 * @see CanteenLookupStartup#startCanteenLookup()
 */
public class CanteenMain {

    /**
     * Starts the canteen application and enters an interactive loop where users can choose between
     * the Canteen Finder, Canteen Lookup, or exit the program.
     * <p>
     * This method continuously prompts the user for input and processes commands as follows:
     * "finder" or "f" starts the Canteen Finder module by invoking
     * {@link CanteenFinderStartup#startCanteenFinder()}.
     * "lookup" or "l" starts the Canteen Lookup module by invoking
     * {@link CanteenLookupStartup#startCanteenLookup()}.
     * "exit" or "e" exits the canteen application by displaying a farewell message and terminating the loop.
     * If an invalid command is entered, an error message is displayed using
     * {@link CanteenMainTextUi#printInvalidCommandC()}, and the user is prompted again.
     *
     * @see CanteenMainTextUi#printCanteenGreetingC()
     * @see CanteenMainTextUi#printExitCanteenC()
     * @see CanteenMainTextUi#printInvalidCommandC()
     * @see CanteenFinderStartup#startCanteenFinder()
     * @see CanteenLookupStartup#startCanteenLookup()
     */
    public static void startCanteen() {
        CanteenMainTextUi.printCanteenGreetingC();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim();
            switch (command.toLowerCase()) {
            case "exit":
            case "e":
                CanteenMainTextUi.printExitCanteenC();
                return;
            case "finder":
            case "f":
                CanteenFinderStartup.startCanteenFinder();
                break;
            case "lookup":
            case "l":
                CanteenLookupStartup.startCanteenLookup();
                break;
            default:
                CanteenMainTextUi.printInvalidCommandC();
            }
        }
    }
}
