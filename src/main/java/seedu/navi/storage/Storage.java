package seedu.navi.storage;

import seedu.navi.canteenfinder.CanteenFinderParser;
import seedu.navi.canteenfinder.landmark.Faculty;
import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;

import java.io.FileNotFoundException;
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

        try {
            CanteenDataProcessor canteenProcessor = new CanteenDataProcessor(canteenMap);
            canteenProcessor.processData();
            assert !canteenMap.isEmpty() : "Canteen map is empty after processing.";
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<Faculty> faculties = new ArrayList<>();
        try {
            FacultyDataProcessor facultyProcessor = new FacultyDataProcessor(canteenMap);
            facultyProcessor.processData(faculties);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<Landmark> hostels = new ArrayList<>();
        try {
            HostelDataProcessor hostelProcessor = new HostelDataProcessor(canteenMap);
            hostelProcessor.processData(hostels);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<Landmark> otherBuildings = new ArrayList<>();
        try {
            OtherBuildingDataProcessor otherBuildingProcessor = new OtherBuildingDataProcessor(canteenMap);
            otherBuildingProcessor.processData(otherBuildings);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        CanteenFinderParser.LANDMARKS.addAll(faculties);
        CanteenFinderParser.LANDMARKS.addAll(hostels);
        CanteenFinderParser.LANDMARKS.addAll(otherBuildings);
    }
}