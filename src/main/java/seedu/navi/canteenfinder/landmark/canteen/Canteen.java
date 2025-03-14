package seedu.navi.canteenfinder.landmark.canteen;

import seedu.navi.canteenfinder.landmark.canteen.stall.Stall;

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

    public boolean isValidCanteen(String[] dietRestrictions) {
        for (Stall stall : stalls) {
            if (stall.hasValidStall(dietRestrictions)) {
                return true;
            }
        }
        return false;
    }
}
