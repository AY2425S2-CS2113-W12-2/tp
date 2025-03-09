package seedu.navi.canteenfinder.nus.landmark;

import java.util.ArrayList;

public abstract class Landmark {
    protected String name;
    // nearest canteen starting at index 0
    protected ArrayList<String> nearestCanteens;

    public Landmark(String name) {
        this.name = name;
        nearestCanteens = new ArrayList<String>();
    }

    public void setNearestCanteens(String order) {

    }
}
