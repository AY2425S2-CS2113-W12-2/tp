package seedu.navi.canteenfinder.nus.landmark;

import seedu.navi.canteenfinder.nus.landmark.canteen.Canteen;

import java.util.ArrayList;

public abstract class Landmark {
    protected String name;
    // nearest canteen starting at index 0
    protected ArrayList<Canteen> nearestCanteens;

    public Landmark(String name) {
        this.name = name;
        nearestCanteens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setNearestCanteens(ArrayList<Canteen> canteens) {
        this.nearestCanteens = canteens;
    }

    public ArrayList<Canteen> getNearestCanteens() {
        return nearestCanteens;
    }
}
