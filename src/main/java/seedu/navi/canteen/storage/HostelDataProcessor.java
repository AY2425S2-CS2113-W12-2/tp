package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HostelDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> hostels) {
        List<String> hostelDataList = DataRetriever.getHostelData();
        for (String hostelData : hostelDataList) {
            insertHostelFromData(hostelData, hostels);
        }
    }

    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        String[] parts = hostelData.split(": ");
        String hostelName = parts[0].trim();
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], hostel, hostelName);
    }

    private void processCanteenData(String canteenDataString, Landmark hostel, String hostelName) {
        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            processCanteenInfo(canteenInfo, hostel, hostelName);
        }
    }

    private void processCanteenInfo(String canteenInfo, Landmark hostel, String hostelName) {
        String[] canteenParts = canteenInfo.trim().split("\\(");
        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            System.err.println("Warning: Canteen '" + canteenName + "' not found for hostel '" +
                    hostelName + "'.");
            return; // Skip processing this canteen info
        }

        hostel.setNearestCanteens(canteen);
        hostel.setCanteenDistance(canteen, distance);
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
}
