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
        List<String> otherBuildingDataList = getOtherBuildingData();
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

    private static List<String> getOtherBuildingData() {
        List<String> data = new ArrayList<>();
        data.add("CELC: Techno Edge (400m) | The Deck (650m) | " +
                "Terrace (850m) | Fine Food (1300m) | " +
                "Flavours (1400m) | Frontier (1400m) | " +
                "PGP Canteen (1800m)");
        data.add("HSSML: Terrace (700m) | The Deck (500m) | " +
                "PGP Canteen (950m) | Techno Edge (1100m) | " +
                "Frontier (1750m) | Fine Food (2000m) | " +
                "Flavours (2100m)");
        data.add("CLB: Techno Edge (200m) | The Deck (750m) | " +
                "Terrace (900m) | Fine Food (1000m) | " +
                "Frontier (1100m) | Flavours (1100m) | " +
                "PGP Canteen (1900m)");
        data.add("MSL: Frontier (200m) | PGP Canteen (1200m) | " +
                "Techno Edge (1300m) | Fine Food (1500m) | " +
                "Flavours (1700m) | The Deck (2000m) | " +
                "Terrace (2200m)");
        data.add("UTown SRC: Fine Food (100m) | Flavours (200m) | " +
                "Techno Edge (1400m) | Frontier (1700m) | " +
                "The Deck (2100m) | Terrace (2300m) | " +
                "PGP Canteen (3100m)");
        data.add("UTown ERC: Flavours (250m) | Fine Food (300m) | " +
                "Techno Edge (1300m) | Frontier (1600m) | " +
                "The Deck (2000m) | Terrace (2200m) | " +
                "PGP Canteen (3000m)");
        data.add("University Hall: Frontier (350m) | Techno Edge (900m) | " +
                "Fine Food (1100m) | Flavours (1200m) | " +
                "The Deck (1600m) | PGP Canteen (1700m) | " +
                "Terrace (1800m)");
        data.add("MPSH: Fine Food (750m) | Techno Edge (850m) | " +
                "Flavours (900m) | Frontier (1100m) | " +
                "The Deck (1500m) | Terrace (2100m) | " +
                "PGP Canteen (2500m)");
        data.add("UHC: Frontier (550m) | Techno Edge (650m) | " +
                "Fine Food (850m) | Flavours (1000m) | " +
                "The Deck (1300m) | Terrace (1500m) | " +
                "PGP Canteen (1900m)");
        return data;
    }
}
