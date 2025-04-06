package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.List;
import java.util.Map;

public class CanteenDataProcessor {

    private final Map<String, Canteen> canteenMap;
    private final List<String> canteenDataList;

    public CanteenDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
        this.canteenDataList = DataRetriever.getCanteenData(); // Get data from CanteenInfo
    }

    public void processData() {
        for (String canteenData : canteenDataList) {
            insertCanteenFromData(canteenData);
        }
    }

    private void insertCanteenFromData(String canteenData) {
        String[] dataFields = canteenData.split("\\|");
        String canteenName = dataFields[0].trim();
        String stallName = dataFields[1].trim();
        boolean halal = dataFields[2].trim().equals("T");
        boolean muslim = dataFields[3].trim().equals("T");
        boolean aircon = dataFields[4].trim().equals("T");
        boolean vegetarian = dataFields[5].trim().equals("T");

        Canteen canteen = canteenMap.getOrDefault(canteenName, new Canteen(canteenName));
        canteen.addStall(new Stall(stallName, halal, muslim, vegetarian, aircon));
        canteenMap.put(canteenName, canteen);
    }
}
