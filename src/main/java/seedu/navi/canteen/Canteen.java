package seedu.navi.canteen;

import seedu.navi.canteen.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenlookup.CanteenLookup;
import seedu.navi.textui.TextUi;

public class Canteen {
    public static void startCanteen() {
        TextUi.printCanteenGreetingC();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim();
            switch (command.toLowerCase()) {
            case "exit":
                TextUi.printExitCanteenC();
                return;
            case "finder":
                CanteenFinder.startCanteenFinder();
                break;
            case "lookup":
                CanteenLookup.startCanteenLookup();
                break;
            default:
                TextUi.printInvalidCommandC();
            }
        }
    }
}
