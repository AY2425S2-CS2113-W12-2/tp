package seedu.navi.canteenfinder.nus;

import seedu.navi.canteenfinder.nus.building.Building;

import java.util.ArrayList;

public class Faculty {
    private final String name;
    private final ArrayList<Building> buildings;

    public Faculty(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public String getName() {
        return name;
    }
}
