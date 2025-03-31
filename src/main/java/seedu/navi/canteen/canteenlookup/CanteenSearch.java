package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.textui.TextUi;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanteenSearch {

    public static void searchCanteen(String canteenName) {
        // Create the canteenMap and dataProcessor
        Map<String, Canteen> canteenMap = new HashMap<>();
        CanteenDataProcessor dataProcessor = new CanteenDataProcessor(canteenMap);

        try {
            dataProcessor.processData();
        } catch (FileNotFoundException e) {
            TextUi.printCanteenDataFileNotFound();
            return; // Exit if file is not found
        }

        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            System.out.println("Canteen not found: " + canteenName);
            return;
        }

        System.out.println("Canteen Name: " + canteen.getName());
        System.out.println("Stalls:");

        ArrayList<Stall> stallList = new ArrayList<>(canteen.getStalls());

        TextUi.printValidStallsCF(stallList);
    }
}