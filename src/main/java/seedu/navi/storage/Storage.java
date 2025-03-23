package seedu.navi.storage;

import seedu.navi.canteenfinder.CanteenFinderParser;
import seedu.navi.canteenfinder.landmark.Faculty;
import seedu.navi.canteenfinder.landmark.OtherBuildings;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteenfinder.landmark.Hostel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    private static final String FACULTY_FILE = "data/faculty.txt";
    private static final String CANTEEN_FILE = "data/canteen.txt";
    private static final String HOSTEL_FILE = "data/hostel.txt";
    private static final String OTHER_BUILDING_FILE = "data/otherbuilding.txt";
    private static final Map<String, Canteen> CANTEEN_MAP = new HashMap<>();

    private static void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties) {
        String[] parts = facultyData.split(": ");
        String facultyName = parts[0];
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);
        String[] canteenData = parts[1].split("\\|");
        for (String canteenInfo : canteenData) {
            String[] canteenParts = canteenInfo.trim().split("\\("); // Split by "("
            String canteenName = canteenParts[0].trim(); // Canteen name
            int distance = 0; // Default distance
            if (canteenParts.length > 1) { // If distance exists
                String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim(); // Extract digits
                if (!distancePart.isEmpty()) {
                    distance = Integer.parseInt(distancePart); // Parse distance
                }
            }
            Canteen canteen = CANTEEN_MAP.get(canteenName.trim());
            faculty.setNearestCanteens(canteen);
            faculty.setCanteenDistance(canteen, distance); // Store distance
        }
    }

    private static void processFacultyFromFile(ArrayList<Faculty> faculties)
            throws FileNotFoundException {
        File f = new File(FACULTY_FILE);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String facultyData = s.nextLine();
            insertFacultyFromData(facultyData, faculties);
        }
    }

    private static void insertCanteenFromData(String canteenData) {
        String[] dataFields = canteenData.split("\\|");
        String canteenName = dataFields[0].trim();
        String stallName = dataFields[1].trim();
        boolean halal = dataFields[2].trim().equals("T");
        boolean muslim = dataFields[3].trim().equals("T");
        boolean aircon = dataFields[4].trim().equals("T");
        boolean vegetarian = dataFields[5].trim().equals("T");

        Canteen canteen = CANTEEN_MAP.getOrDefault(canteenName, new Canteen(canteenName));
        canteen.addStall(new Stall(stallName, halal, muslim, vegetarian, aircon));
        CANTEEN_MAP.put(canteenName, canteen);
    }

    private static void processCanteenFromFile()
            throws FileNotFoundException {
        File f = new File(CANTEEN_FILE);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String canteenData = s.nextLine();
            insertCanteenFromData(canteenData);
        }
    }

    private static void insertHostelFromData(String hostelData, ArrayList<Hostel> hostels) {
        String[] parts = hostelData.split(": ");
        String hostelName = parts[0];
        Hostel hostel = new Hostel(hostelName);
        hostels.add(hostel);
        String[] canteenData = parts[1].split("\\|");
        for (String canteenInfo : canteenData) {
            String[] canteenParts = canteenInfo.trim().split("\\("); // Split by "(" to separate name and distance
            String canteenName = canteenParts[0].trim(); // Canteen name
            int distance = 0; // Default distance
            if (canteenParts.length > 1) { // If distance exists
                String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim(); // Extract digits only
                if (!distancePart.isEmpty()) {
                    distance = Integer.parseInt(distancePart); // Parse distance
                }
            }
            Canteen canteen = CANTEEN_MAP.get(canteenName.trim());
            hostel.setNearestCanteens(canteen);
            hostel.setCanteenDistance(canteen, distance); // Store distance (assuming Hostel has this method)
        }
    }

    private static void processHostelFromFile(ArrayList<Hostel> hostels)
            throws FileNotFoundException {
        File f = new File(HOSTEL_FILE);
        assert f.exists() : "Hostel file does not exist: " + HOSTEL_FILE; // Assert file exists
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String hostelData = s.nextLine();
            insertHostelFromData(hostelData, hostels);
        }
    }

    private static void insertOtherBuildingFromData(String otherBuildingData,
                                                    ArrayList<OtherBuildings> otherBuildings) {
        String[] parts = otherBuildingData.split(": ");
        String otherBuildingName = parts[0];
        OtherBuildings otherBuilding = new OtherBuildings(otherBuildingName);
        otherBuildings.add(otherBuilding);
        String[] canteenData = parts[1].split("\\|");
        for (String canteenInfo : canteenData) {
            String[] canteenParts = canteenInfo.trim().split("\\("); // Split by "("
            String canteenName = canteenParts[0].trim(); // Canteen name
            int distance = 0; // Default distance
            if (canteenParts.length > 1) { // If distance exists
                String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim(); // Extract digits
                if (!distancePart.isEmpty()) {
                    distance = Integer.parseInt(distancePart); // Parse distance
                }
            }
            Canteen canteen = CANTEEN_MAP.get(canteenName.trim());
            otherBuilding.setNearestCanteens(canteen);
            otherBuilding.setCanteenDistance(canteen, distance); // Store distance
        }
    }

    private static void processOtherBuildingFromFile(ArrayList<OtherBuildings> otherBuildings)
            throws FileNotFoundException {
        File f = new File(OTHER_BUILDING_FILE);
        assert f.exists() : "Other building file does not exist: " + OTHER_BUILDING_FILE;
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String otherBuildingData = s.nextLine();
            insertOtherBuildingFromData(otherBuildingData, otherBuildings);
        }
    }

    public static Map<String, Canteen> getCanteenMap() {
        return CANTEEN_MAP; // Return the class-level field
    }

    public static void processDataFromFiles() {
        CANTEEN_MAP.clear(); // Clear the map before processing new data
        try {
            processCanteenFromFile();
            assert !CANTEEN_MAP.isEmpty() : "Canteen map is empty after processing.";
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<Faculty> faculties = new ArrayList<>();
        Map<String, Faculty> facultyMap = new HashMap<>(); // added facultyMap
        try {
            processFacultyFromFile(faculties);
            for (Faculty faculty : faculties) { // added loop
                facultyMap.put(faculty.getName(), faculty);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<Hostel> hostels = new ArrayList<>(); // Added hostel ArrayList
        try {
            processHostelFromFile(hostels); // Added processHostelFromFile call
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        ArrayList<OtherBuildings> otherBuildings = new ArrayList<>(); // Added Place ArrayList
        try {
            processOtherBuildingFromFile(otherBuildings); // Added processOtherBuildingFromFile call
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        CanteenFinderParser.LANDMARKS.addAll(faculties);
        CanteenFinderParser.LANDMARKS.addAll(hostels); //added building to landmarks.
        CanteenFinderParser.LANDMARKS.addAll(otherBuildings);
    }
}
