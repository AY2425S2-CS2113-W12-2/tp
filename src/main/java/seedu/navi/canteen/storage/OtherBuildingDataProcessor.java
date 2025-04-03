package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OtherBuildingDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public OtherBuildingDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> otherBuildings) {
        List<String> otherBuildingDataList = DataRetriever.getOtherBuildingData();
        for (String otherBuildingData : otherBuildingDataList) {
            insertOtherBuildingFromData(otherBuildingData, otherBuildings);
        }
    }

    private void insertOtherBuildingFromData(String otherBuildingData, ArrayList<Landmark> otherBuildings) {
        String[] parts = otherBuildingData.split(": ");
        String otherBuildingName = parts[0].trim();
        Landmark otherBuilding = new Landmark(otherBuildingName);
        otherBuildings.add(otherBuilding);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], otherBuilding, otherBuildingName);
    }

    private void processCanteenData(String canteenDataString, Landmark otherBuilding, String otherBuildingName) {
        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            processCanteenInfo(canteenInfo, otherBuilding, otherBuildingName);
        }
    }

    private void processCanteenInfo(String canteenInfo, Landmark otherBuilding, String otherBuildingName) {
        String[] canteenParts = canteenInfo.trim().split("\\(");
        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            System.err.println("Warning: Canteen '" + canteenName +
                    "' not found for other building '" + otherBuildingName + "'.");
            return; // Skip processing this canteen info
        }

        otherBuilding.setNearestCanteens(canteen);
        otherBuilding.setCanteenDistance(canteen, distance);
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
