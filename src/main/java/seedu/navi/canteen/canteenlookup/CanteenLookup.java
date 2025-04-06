package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.textui.TextUi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanteenLookup {

    public static void lookupCanteen(String canteenName) {
        // Create the canteenMap and dataProcessor
        Map<String, Canteen> canteenMap = new HashMap<>();
        CanteenDataProcessor dataProcessor = new CanteenDataProcessor(canteenMap);

        // No need for try-catch here, as CanteenInfo loads data from memory
        dataProcessor.processData();

        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new CanteenNotFound();
        }

        ArrayList<Stall> stalls = canteen.getStalls();
        TextUi.printCanteenStallsCL(canteenName, stalls);
    }
}
