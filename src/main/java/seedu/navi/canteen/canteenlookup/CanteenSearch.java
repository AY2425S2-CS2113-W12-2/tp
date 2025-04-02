package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.storage.CanteenDataProcessor; // Import the modified CanteenDataProcessor
import seedu.navi.textui.TextUi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanteenSearch {

    public static void searchCanteen(String canteenName) {
        // Create the canteenMap and dataProcessor
        Map<String, Canteen> canteenMap = new HashMap<>();
        CanteenDataProcessor dataProcessor = new CanteenDataProcessor(canteenMap);

        dataProcessor.processData();

        Canteen canteen = canteenMap.get(canteenName);

        System.out.println("Canteen Name: " + canteen.getName());
        System.out.println("Stalls:");

        ArrayList<Stall> stalls = new ArrayList<>(canteen.getStalls());
        TextUi.printCanteenStallsCL(canteenName, stalls);
    }
}
