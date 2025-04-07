package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.DataProcessingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the storage and initialization of canteen-related data.
 * This includes reading and processing data from files to populate
 * canteen mappings and associated landmarks (faculties, hostels, and buildings).
 */
public class Storage {

    private static final Map<String, Canteen> canteenMap = new HashMap<>();

    /**
     * Returns the map of canteen names to their corresponding {@code Canteen} objects.
     *
     * @return A map containing canteen data.
     */
    public static Map<String, Canteen> getCanteenMap() {
        return canteenMap;
    }

    public static void processDataFromFiles() {
        canteenMap.clear();

        try {
            CanteenDataProcessor canteenProcessor = new CanteenDataProcessor(canteenMap);
            canteenProcessor.processData();
            if (canteenMap.isEmpty()) {
                throw new DataProcessingException("Canteen map is empty after processing.");
            }

            ArrayList<Faculty> faculties = new ArrayList<>();
            FacultyDataProcessor facultyProcessor = new FacultyDataProcessor(canteenMap);
            facultyProcessor.processData(faculties);
            assert faculties != null : "Faculties list is null";

            ArrayList<Landmark> hostels = new ArrayList<>();
            HostelDataProcessor hostelProcessor = new HostelDataProcessor(canteenMap);
            hostelProcessor.processData(hostels);
            assert hostels != null : "Hostels list is null";

            ArrayList<Landmark> otherBuildings = new ArrayList<>();
            OtherBuildingDataProcessor otherBuildingProcessor = new OtherBuildingDataProcessor(canteenMap);
            otherBuildingProcessor.processData(otherBuildings);
            assert otherBuildings != null : "Other buildings list is null";

            CanteenFinder.LANDMARKS.addAll(faculties);
            CanteenFinder.LANDMARKS.addAll(hostels);
            CanteenFinder.LANDMARKS.addAll(otherBuildings);
            assert !CanteenFinder.LANDMARKS.isEmpty() : "LANDMARKS list is empty after processing.";

        } catch (RuntimeException e) {
            throw new DataProcessingException("Failed to process data from files: " + e.getMessage(), e);
        }
    }
}
