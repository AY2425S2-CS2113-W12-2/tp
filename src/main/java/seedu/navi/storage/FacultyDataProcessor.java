package seedu.navi.storage;

import seedu.navi.canteenfinder.landmark.Faculty;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;

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
}