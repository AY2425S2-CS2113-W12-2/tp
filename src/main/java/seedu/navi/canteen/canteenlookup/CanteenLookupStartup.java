package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.usershortcuts.CanteenShortcuts;
import seedu.navi.textui.CanteenLookupTextUi;
import seedu.navi.textui.TextUi;

/**
 * The CanteenLookupStartup class serves as the entry point for the Canteen Lookup module.
 * It provides an interactive interface for users to search for specific canteens by name or shortcut.
 */
public class CanteenLookupStartup {

    /**
     * Starts the Canteen Lookup application and enters an interactive loop where users can search
     * for canteens by entering their names or shortcuts.
     * <p>
     * This method continuously prompts the user for input and processes commands as follows:
     * "exit" or "e" exits the Canteen Lookup application by displaying a farewell message and
     * terminating the loop. For other inputs, the method resolves the input to a canteen name using
     * {@link CanteenShortcuts#CANTEEN_MAP}. If the input matches a valid canteen, the method invokes
     * {@link CanteenLookup#lookupCanteen(String)} to display details about the canteen. If no match
     * is found, an error message is displayed using {@link CanteenLookupTextUi#printCanteenNotFoundCL()}, and the
     * user is prompted again.
     *
     * @see CanteenLookupTextUi#printCanteenLookupGreetingCL()
     * @see CanteenLookupTextUi#printExitCanteenLookupCL()
     * @see CanteenLookupTextUi#printCanteenNotFoundCL()
     * @see CanteenShortcuts#CANTEEN_MAP
     * @see CanteenLookup#lookupCanteen(String)
     */
    public static void startCanteenLookup() {
        CanteenLookupTextUi.printCanteenLookupGreetingCL();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim().toLowerCase();
            if (command.equalsIgnoreCase("e") ||
                    command.equalsIgnoreCase("exit")) {
                CanteenLookupTextUi.printExitCanteenLookupCL();
                break;
            }
            String canteenName = CanteenShortcuts.CANTEEN_MAP.get(command);
            if (canteenName == null) {
                CanteenLookupTextUi.printCanteenNotFoundCL();
            } else {
                CanteenLookup.lookupCanteen(canteenName);
            }
        }
    }
}
