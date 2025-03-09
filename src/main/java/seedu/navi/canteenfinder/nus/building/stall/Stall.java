package seedu.navi.canteenfinder.nus.building.stall;

public class Stall {
    private final String name;
    private StallCharacteristic stallCharacteristic;

    public Stall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StallCharacteristic getStallCharacteristic() {
        return stallCharacteristic;
    }

    public void setStallCharacteristic(StallCharacteristic stallCharacteristic) {
        this.stallCharacteristic = stallCharacteristic;
    }
}
