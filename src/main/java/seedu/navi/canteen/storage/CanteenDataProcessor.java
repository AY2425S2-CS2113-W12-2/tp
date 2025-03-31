
package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class CanteenDataProcessor {

    private static final String CANTEEN_FILE = "data/canteen.txt";
    private final Map<String, Canteen> canteenMap;

    public CanteenDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData() throws FileNotFoundException {
        File f = new File(CANTEEN_FILE);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String canteenData = s.nextLine();
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

    public Map<String, Canteen> getCanteenMap(){
        return this.canteenMap;
    }
}
