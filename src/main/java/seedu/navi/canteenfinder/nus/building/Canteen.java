package seedu.navi.canteenfinder.nus.building;

import seedu.navi.canteenfinder.nus.building.stall.Stall;

import java.util.ArrayList;

public class Canteen extends Building {
    private final ArrayList<Stall> stalls;

    public Canteen(String name) {
        super(name);
        this.stalls = new ArrayList<>();
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
    }
}
