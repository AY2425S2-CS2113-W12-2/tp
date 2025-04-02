package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacultyDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public FacultyDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Faculty> faculties) {
        List<String> facultyDataList = getFacultyData(); // Get data from method.
        for (String facultyData : facultyDataList) {
            insertFacultyFromData(facultyData, faculties);
        }
    }

    private void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties) {
        String[] parts = facultyData.split(": ");
        String facultyName = parts[0].trim();
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], faculty, facultyName);
    }

    private void processCanteenData(String canteenDataString, Faculty faculty, String facultyName) {
        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            processCanteenInfo(canteenInfo, faculty, facultyName);
        }
    }

    private void processCanteenInfo(String canteenInfo, Faculty faculty, String facultyName) {
        String[] canteenParts = canteenInfo.trim().split("\\(");
        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            System.err.println("Warning: Canteen '" + canteenName + "' not found for faculty '" +
                    facultyName + "'.");
            return; // Skip processing this canteen info
        }

        faculty.setNearestCanteens(canteen);
        faculty.setCanteenDistance(canteen, distance);
    }

    private int extractDistance(String[] canteenParts) {
        if (canteenParts.length <= 1) {
            return 0; // Default distance if not found
        }

        String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
        if (distancePart.isEmpty()) {
            return 0; // Default distance if not found
        }

        return Integer.parseInt(distancePart);
    }

    private static List<String> getFacultyData() {
        List<String> data = new ArrayList<>();
        data.add("CDE: Techno Edge (400m) | Fine Food (850m) | " +
                "Flavours (1000m) | The Deck (1100m) | " +
                "Frontier (1300m) | Terrace (1700m) | " +
                "PGP Canteen (2300m)");
        data.add("FASS: The Deck (300m) | Terrace (450m) | " +
                "Techno Edge (550m) | PGP Canteen (1400m) | " +
                "Fine Food (1400m) | Frontier (1500m) | " +
                "Flavours (1600m)");
        data.add("SOC: Terrace (100m) | The Deck (220m) | " +
                "PGP Canteen (1000m) | Techno Edge (1000m) | " +
                "Fine Food (1900m) | Frontier (2000m) | " +
                "Flavours (2000m)");
        data.add("NBS: The Deck (400m) | Terrace (450m) | " +
                "PGP Canteen (1000m) | Techno Edge (1000m) | " +
                "Frontier (1800m) | Fine Food (1900m) | " +
                "Flavours (2000m)");
        data.add("Science: Frontier (220m) | Techno Edge (1100m) | " +
                "Fine Food (1300m) | PGP Canteen (1400m) | " +
                "Flavours (1500m) | Terrace (1700m) | " +
                "The Deck (1800m)");
        return data;
    }
}
