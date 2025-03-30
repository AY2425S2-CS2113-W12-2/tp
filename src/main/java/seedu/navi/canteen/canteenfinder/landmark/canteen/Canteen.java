package seedu.navi.canteen.canteenfinder.landmark.canteen;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

public class Canteen {
    private String name;
    private ArrayList<Stall> stalls;

    public Canteen(String name) {
        this.name = name.toLowerCase();
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

    public ArrayList<Stall> findValidStalls(String[] canteenCriteria) {
        ArrayList<Stall> validStalls = new ArrayList<>();
        for (Stall stall : stalls) {
            if (stall.isValidStall(canteenCriteria)) {
                validStalls.add(stall);
            }
        }
        return validStalls;
    }
}
