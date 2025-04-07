package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidFacultyDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacultyDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public FacultyDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Faculty> faculties) {
        assert faculties != null : "Faculty list should not be null";

        List<String> facultyDataList = DataRetriever.getFacultyData();
        for (String facultyData : facultyDataList) {
            insertFacultyFromData(facultyData, faculties);
        }
    }


    private void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties) {
        assert facultyData != null : "Faculty data line should not be null";
        assert faculties != null : "Faculty list should not be null";

        String[] parts = facultyData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidFacultyDataException("Missing faculty name in: " + facultyData);
        }

        String facultyName = parts[0].trim();
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], faculty, facultyName);
    }

    private void processCanteenData(String canteenDataString, Faculty faculty, String facultyName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, faculty, facultyName);
            } catch (InvalidFacultyDataException e) {
                // Skip this specific canteen entry
            }
        }
    }

    private void processCanteenInfo(String canteenInfo, Faculty faculty, String facultyName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidFacultyDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidFacultyDataException("Canteen '" + canteenName +
                    "' not found for faculty '" + facultyName + "'");
        }

        faculty.setNearestCanteens(canteen);
        faculty.setCanteenDistance(canteen, distance);
    }

    private int extractDistance(String[] canteenParts) {
        assert canteenParts != null : "Canteen parts should not be null";

        if (canteenParts.length <= 1) {
            return 0; // Default distance if not found
        }

        String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
        if (distancePart.isEmpty()) {
            return 0; // Default distance if not found
        }

        return Integer.parseInt(distancePart);
    }
}
