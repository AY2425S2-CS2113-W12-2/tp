package seedu.navi.canteen.canteenlookup;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.storage.CanteenDataProcessor;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.textui.CanteenLookupTextUi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The CanteenLookup class provides functionality to look up and display information about a specific canteen.
 * It retrieves canteen data from a data processor and displays the stalls associated with the canteen.
 */
public class CanteenLookup {

    /**
     * Looks up a canteen by its name and displays its associated stalls.
     * <p>
     * This method performs the following steps:
     * 1. Creates a {@link HashMap} to store canteen data and initializes a {@link CanteenDataProcessor}
     * to load the data.
     * 2. Processes the canteen data using {@link CanteenDataProcessor#processData()}.
     * 3. Retrieves the canteen object from the map using the provided canteen name.
     * 4. If the canteen is not found, throws a {@link CanteenNotFound} exception.
     * 5. Retrieves the list of stalls associated with the canteen and displays them using
     *    {@link CanteenLookupTextUi#printCanteenStallsCL(String, ArrayList)}.
     *
     * @param canteenName The name of the canteen to look up.
     * @throws CanteenNotFound If no canteen is found with the specified name.
     * @see CanteenDataProcessor#processData()
     * @see CanteenLookupTextUi#printCanteenStallsCL(String, ArrayList)
     */
    public static void lookupCanteen(String canteenName) {
        Map<String, Canteen> canteenMap = new HashMap<>();
        CanteenDataProcessor dataProcessor = new CanteenDataProcessor(canteenMap);

        // No need for try-catch here, as CanteenInfo loads data from memory
        dataProcessor.processData();

        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new CanteenNotFound();
        }

        ArrayList<Stall> stalls = canteen.getStalls();
        CanteenLookupTextUi.printCanteenStallsCL(canteenName, stalls);
    }
}
