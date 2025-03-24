package seedu.navi.canteenfinder.landmark.canteen;

import seedu.navi.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

public class Canteen {
    private String name;
    private ArrayList<Stall> stalls;

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

    public ArrayList<String> findValidStalls(String[] dietRestrictions) {
        ArrayList<String> validStalls = new ArrayList<>();
        for (Stall stall : stalls) {
            if (stall.isValidStall(dietRestrictions)) {
                validStalls.add(stall.getName());
            }
        }
        return validStalls;
    }
}
