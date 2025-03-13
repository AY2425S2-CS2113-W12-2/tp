package seedu.navi.storage;

import seedu.navi.canteenfinder.CanteenFinder;
import seedu.navi.canteenfinder.landmark.Faculty;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteenfinder.landmark.canteen.stall.Stall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    private static final String FACULTY_FILE = "data/faculty.txt";
    private static final String CANTEEN_FILE = "data/canteen.txt";

    private static void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties,
                                              Map<String, Canteen> canteenMap) {
        String[] parts = facultyData.split(": ");
        String facultyName = parts[0];
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);
        String[] canteenNames = parts[1].split("\\|");
        for (String canteenName : canteenNames) {
            Canteen canteen = canteenMap.get(canteenName.trim());
            faculty.setNearestCanteens(canteen);
        }
    }

    private static void processFacultyFromFile(ArrayList<Faculty> faculties,
                                               Map<String, Canteen> canteenMap)
            throws FileNotFoundException {
        File f = new File(FACULTY_FILE);
        Scanner s = new Scanner(f);
        while(s.hasNext()) {
            String facultyData = s.nextLine();
            insertFacultyFromData(facultyData, faculties, canteenMap);
        }
    }

    private static void insertCanteenFromData(String canteenData,
                                              Map<String, Canteen> canteenMap) {
        String[] dataFields = canteenData.split("\\|");
        String canteenName = dataFields[0].trim();
        String stallName = dataFields[1].trim();
        boolean halal = dataFields[2].trim().equals("T");
        boolean muslim = dataFields[3].trim().equals("T");
        boolean vegetarian = dataFields[4].trim().equals("T");
        boolean aircon = dataFields[5].trim().equals("T");

        Canteen canteen = canteenMap.getOrDefault(canteenName, new Canteen(canteenName));
        canteen.addStall(new Stall(stallName, halal, muslim, vegetarian, aircon));
        canteenMap.put(canteenName, canteen);
    }

    private static void processCanteenFromFile(Map<String, Canteen> canteenMap)
            throws FileNotFoundException {
        File f = new File(CANTEEN_FILE);
        Scanner s = new Scanner(f);
        while(s.hasNext()) {
            String canteenData = s.nextLine();
            insertCanteenFromData(canteenData, canteenMap);
        }
    }

    public static void processDataFromFiles() {
        Map<String, Canteen> canteenMap = new HashMap<>();
        try {
            processCanteenFromFile(canteenMap);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        ArrayList<Faculty> faculties = new ArrayList<>();
        try {
            processFacultyFromFile(faculties, canteenMap);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        CanteenFinder.LANDMARKS.addAll(faculties);
    }
}
