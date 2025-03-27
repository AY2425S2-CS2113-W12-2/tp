package seedu.navi.storage;

import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.canteen.Canteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class HostelDataProcessor {

    private static final String HOSTEL_FILE = "data/hostel.txt";
    private final Map<String, Canteen> canteenMap;

    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> hostels) throws FileNotFoundException {
        File f = new File(HOSTEL_FILE);
        assert f.exists() : "Hostel file does not exist: " + HOSTEL_FILE;
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String hostelData = s.nextLine();
            insertHostelFromData(hostelData, hostels);
        }
    }

    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        String[] parts = hostelData.split(": ");
        String hostelName = parts[0];
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);
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
            hostel.setNearestCanteens(canteen);
            hostel.setCanteenDistance(canteen, distance);
        }
    }
}
