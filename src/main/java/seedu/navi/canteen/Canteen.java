package seedu.navi.canteen;

import seedu.navi.canteen.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenlookup.CanteenLookup;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.textui.TextUi;



public class Canteen {
    public static void startCanteen(CanteenDataProcessor dataProcessor) {
        TextUi.printCanteenGreetingC();
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim();
            switch (command.toLowerCase()) {
            case "quit":
            case "q":
                TextUi.printExitCanteenC();
                return;
            case "finder":
            case "f":
                CanteenFinder.startCanteenFinder();
                break;
            case "lookup":
            case "l":
                CanteenLookup.startCanteenLookup(dataProcessor);
                break;
            default:
                TextUi.printInvalidCommandC();
            }
        }
    }
}


