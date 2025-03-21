package seedu.navi.canteenfinder.landmark;

import seedu.navi.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Landmark {
    protected String name;
    // nearest canteen starting at index 0
    protected ArrayList<Canteen> nearestCanteens;
    protected Map<Canteen, Integer> canteenDistances; // Add distance storage

    public Landmark(String name) {
        this.name = name;
        nearestCanteens = new ArrayList<>();
        canteenDistances = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setNearestCanteens(Canteen canteen) {
        nearestCanteens.add(canteen);
    }

    public Canteen getNearestCanteen(String[] dietRestrictions) {
        for (Canteen canteen : nearestCanteens) {
            if (canteen.isValidCanteen(dietRestrictions)) {
                return canteen;
            }
        }
        return null;
    }

    public void setCanteenDistance(Canteen canteen, int distance) {
        canteenDistances.put(canteen, distance);
    }

    public int getCanteenDistance(Canteen canteen) {
        return canteenDistances.getOrDefault(canteen, -1);
    }

    public Map<Canteen, Integer> getCanteenDistances(){
        return this.canteenDistances;
    }
}
