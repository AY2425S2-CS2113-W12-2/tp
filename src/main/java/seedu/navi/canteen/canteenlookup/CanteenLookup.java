package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.usershortcuts.CanteenShortcuts;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.textui.TextUi;

public class CanteenLookup {
    public static void startCanteenLookup(CanteenDataProcessor dataProcessor) {
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
                if (dataProcessor.getCanteenMap().containsKey(command)) {
                    canteenName = command;
                } else {
                    canteenName = command;
                }
            }
            CanteenSearch.searchCanteen(canteenName, dataProcessor);
        }
    }
}
