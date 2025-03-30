package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen; // Import Canteen
import seedu.navi.textui.TextUi; // Import TextUi
import java.util.Map;
import java.util.ArrayList;

public class CanteenSearch {
    public static void searchCanteen(String canteenName, CanteenDataProcessor dataProcessor) {
        Map<String, Canteen> canteenMap = dataProcessor.getCanteenMap();
        String lowercaseCanteenName = canteenName.toLowerCase(); // Convert to lowercase for search
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
