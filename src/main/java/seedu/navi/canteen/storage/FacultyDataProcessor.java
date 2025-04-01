/* package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FacultyDataProcessor {

    private static final String FACULTY_FILE = "data/faculty.txt";
    private final Map<String, Canteen> canteenMap;

    public FacultyDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Faculty> faculties) throws FileNotFoundException {
        File f = new File(FACULTY_FILE);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String facultyData = s.nextLine();
            insertFacultyFromData(facultyData, faculties);
        }
    }

    private void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties) {
        String[] parts = facultyData.split(": ");
        String facultyName = parts[0];
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);
        String[] canteenData = parts[1].split("\\|");
        for (String canteenInfo : canteenData) {
            String[] canteenParts = canteenInfo.trim().split("\\(");
            String canteenName = canteenParts[0].trim();
            int distance = 0;
            if (canteenParts.length > 1) {
                String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
                if (!distancePart.isEmpty()) {
                    distance = Integer.parseInt(distancePart);
                }
            }
            Canteen canteen = canteenMap.get(canteenName.trim());
            faculty.setNearestCanteens(canteen);
            faculty.setCanteenDistance(canteen, distance);
        }
    }
} */


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
        if (parts.length > 1) { // Check if canteen data exists
            String[] canteenData = parts[1].split("\\|");
            for (String canteenInfo : canteenData) {
                String[] canteenParts = canteenInfo.trim().split("\\(");
                String canteenName = canteenParts[0].trim();
                int distance = 0;
                if (canteenParts.length > 1) {
                    String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
                    if (!distancePart.isEmpty()) {
                        distance = Integer.parseInt(distancePart);
                    }
                }
                Canteen canteen = canteenMap.get(canteenName);
                if (canteen != null) { // Check if canteen exists in map
                    faculty.setNearestCanteens(canteen);
                    faculty.setCanteenDistance(canteen, distance);
                } else {
                    System.err.println("Warning: Canteen '" + canteenName + "' not found for faculty '" +
                            facultyName + "'.");
                }
            }
        }
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
