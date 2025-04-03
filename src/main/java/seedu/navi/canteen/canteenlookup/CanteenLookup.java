package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.usershortcuts.CanteenShortcuts;
import seedu.navi.textui.TextUi;

public class CanteenLookup {
    public static void startCanteenLookup() {
        TextUi.printCanteenLookupGreetingCL();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim().toLowerCase();
            if (command.equalsIgnoreCase("e") ||
                    command.equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenLookupCL();
                break;
            }
            String canteenName = CanteenShortcuts.CANTEEN_MAP.get(command);
            if (canteenName == null) {
                System.out.println("Canteen \"" + command + "\" not found."); // Updated error message
                System.out.println("Valid shortcuts: " + CanteenShortcuts.CANTEEN_MAP.keySet()); // Show valid shortcuts
            } else {
                CanteenSearch.searchCanteen(canteenName);
            }
        }
    }
}
