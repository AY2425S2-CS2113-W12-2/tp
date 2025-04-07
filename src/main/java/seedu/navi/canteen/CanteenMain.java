package seedu.navi.canteen;

import seedu.navi.canteen.canteenfinder.CanteenFinderStartup;
import seedu.navi.canteen.canteenlookup.CanteenLookupStartup;
import seedu.navi.textui.CanteenMainTextUi;
import seedu.navi.textui.NaviTextUi;

/**
 * The CanteenMain class serves as the entry point for the canteen-related functionalities.
 * It provides a command-driven interface for users to interact with the Canteen Finder and
 * Canteen Lookup modules. Users can choose between these modules or exit the program by entering
 * specific commands.
 * <p>
 * This class continuously prompts the user for input until they explicitly exit the program.
 */
public class CanteenMain {

    /**
     * Starts the canteen application and enters an interactive loop where users can choose between
     * the Canteen Finder, Canteen Lookup, or exit the program.
     * <p>
     * This method continuously prompts the user for input and processes commands
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
            command = NaviTextUi.IN.nextLine().trim();
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
