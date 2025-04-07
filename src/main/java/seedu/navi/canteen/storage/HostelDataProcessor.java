package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidHostelDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HostelDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> hostels) {
        assert hostels != null : "Hostel list should not be null";

        List<String> hostelDataList = DataRetriever.getHostelData(); // Assume this never returns null
        for (String hostelData : hostelDataList) {
            try {
                insertHostelFromData(hostelData, hostels);
            } catch (InvalidHostelDataException e) {
                // Skipping invalid hostel data silently
            }
        }
    }

    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        assert hostelData != null : "Hostel data line should not be null";
        assert hostels != null : "Hostel list should not be null";

        String[] parts = hostelData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidHostelDataException("Missing hostel name in: " + hostelData);
        }

        String hostelName = parts[0].trim();
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], hostel, hostelName);
    }

    private void processCanteenData(String canteenDataString, Landmark hostel, String hostelName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, hostel, hostelName);
            } catch (InvalidHostelDataException e) {
                // Skip this specific canteen info
            }
        }
    }

    private void processCanteenInfo(String canteenInfo, Landmark hostel, String hostelName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidHostelDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidHostelDataException("Canteen '" + canteenName +
                    "' not found for hostel '" + hostelName + "'");
        }

        hostel.setNearestCanteens(canteen);
        hostel.setCanteenDistance(canteen, distance);
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
