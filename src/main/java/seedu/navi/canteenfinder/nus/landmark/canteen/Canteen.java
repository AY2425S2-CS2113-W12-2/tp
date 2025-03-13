package seedu.navi.canteenfinder.nus.landmark.canteen;

import seedu.navi.canteenfinder.nus.landmark.canteen.stall.Stall;

import java.util.ArrayList;

public class Canteen {
    private final String name;
    private final ArrayList<Stall> stalls;

    public Canteen(String name) {
        this.name = name;
        this.stalls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }
}
