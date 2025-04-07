package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidOtherBuildingDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OtherBuildingDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public OtherBuildingDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> otherBuildings) {
        assert otherBuildings != null : "Other building list should not be null";

        List<String> otherBuildingDataList = DataRetriever.getOtherBuildingData(); // Assume never null
        for (String otherBuildingData : otherBuildingDataList) {
            try {
                insertOtherBuildingFromData(otherBuildingData, otherBuildings);
            } catch (InvalidOtherBuildingDataException e) {
                // Skip invalid entry silently
            }
        }
    }

    private void insertOtherBuildingFromData(String otherBuildingData, ArrayList<Landmark> otherBuildings) {
        assert otherBuildingData != null : "Other building data line should not be null";
        assert otherBuildings != null : "Other building list should not be null";

        String[] parts = otherBuildingData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidOtherBuildingDataException("Missing other building name in: " + otherBuildingData);
        }

        String otherBuildingName = parts[0].trim();
        Landmark otherBuilding = new Landmark(otherBuildingName);
        otherBuildings.add(otherBuilding);

        if (parts.length <= 1) {
            return; // No canteen data
        }

        processCanteenData(parts[1], otherBuilding, otherBuildingName);
    }

    private void processCanteenData(String canteenDataString, Landmark otherBuilding, String otherBuildingName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, otherBuilding, otherBuildingName);
            } catch (InvalidOtherBuildingDataException e) {
                // Skip this canteen info silently
            }
        }
    }

    private void processCanteenInfo(String canteenInfo, Landmark otherBuilding, String otherBuildingName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidOtherBuildingDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidOtherBuildingDataException(
                    "Canteen '" + canteenName + "' not found for other building '" + otherBuildingName + "'");
        }

        otherBuilding.setNearestCanteens(canteen);
        otherBuilding.setCanteenDistance(canteen, distance);
    }

    private int extractDistance(String[] canteenParts) {
        assert canteenParts != null : "Canteen parts should not be null";

        if (canteenParts.length <= 1) {
            return 0;
        }

        String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
        if (distancePart.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(distancePart);
    }
}
