package seedu.navi.canteen;

import seedu.navi.canteen.canteenfinder.CanteenFinderStartup;
import seedu.navi.canteen.canteenlookup.CanteenLookupStartup;
import seedu.navi.textui.TextUi;

public class CanteenMain {
    public static void startCanteen() {
        TextUi.printCanteenGreetingC();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim();
            switch (command.toLowerCase()) {
            case "exit":
            case "e":
                TextUi.printExitCanteenC();
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
                TextUi.printInvalidCommandC();
            }
        }
    }
}
