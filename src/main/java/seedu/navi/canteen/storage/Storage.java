package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Canteen> canteenMap = new HashMap<>();

    public static Map<String, Canteen> getCanteenMap() {
        return canteenMap;
    }

    public static void processDataFromFiles() {
        canteenMap.clear();

        // No need for try-catch here for CanteenDataProcessor
        CanteenDataProcessor canteenProcessor = new CanteenDataProcessor(canteenMap);
        canteenProcessor.processData();
        assert !canteenMap.isEmpty() : "Canteen map is empty after processing.";

        ArrayList<Faculty> faculties = new ArrayList<>();
        FacultyDataProcessor facultyProcessor = new FacultyDataProcessor(canteenMap);
        facultyProcessor.processData(faculties);

        ArrayList<Landmark> hostels = new ArrayList<>();
        HostelDataProcessor hostelProcessor = new HostelDataProcessor(canteenMap);
        hostelProcessor.processData(hostels);

        ArrayList<Landmark> otherBuildings = new ArrayList<>();
        OtherBuildingDataProcessor otherBuildingProcessor = new OtherBuildingDataProcessor(canteenMap);
        otherBuildingProcessor.processData(otherBuildings);

        CanteenFinder.LANDMARKS.addAll(faculties);
        CanteenFinder.LANDMARKS.addAll(hostels);
        CanteenFinder.LANDMARKS.addAll(otherBuildings);
    }
}
