package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class OtherBuildingDataProcessor {

    private static final String OTHER_BUILDING_FILE = "data/otherbuilding.txt";
    private final Map<String, Canteen> canteenMap;

    public OtherBuildingDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> otherBuildings) throws FileNotFoundException {
        File f = new File(OTHER_BUILDING_FILE);
        assert f.exists() : "Other building file does not exist: " + OTHER_BUILDING_FILE;
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String otherBuildingData = s.nextLine();
            insertOtherBuildingFromData(otherBuildingData, otherBuildings);
        }
    }

    private void insertOtherBuildingFromData(String otherBuildingData, ArrayList<Landmark> otherBuildings) {
        String[] parts = otherBuildingData.split(": ");
        String otherBuildingName = parts[0];
        Landmark otherBuilding = new Landmark(otherBuildingName);
        otherBuildings.add(otherBuilding);
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
            otherBuilding.setNearestCanteens(canteen);
            otherBuilding.setCanteenDistance(canteen, distance);
        }
    }
}
