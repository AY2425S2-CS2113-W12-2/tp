package seedu.navi.canteenfinder.nus.landmark.canteen.stall;

public class Stall {
    private final String name;
    private final StallCharacteristic stallCharacteristic;

    public Stall(String name) {
        this.name = name;
        stallCharacteristic = new StallCharacteristic();
    }

    public Stall(String name, boolean halalCertified, boolean muslimOwned,
                 boolean vegetarian, boolean inAirconArea) {
        this.name = name;
        stallCharacteristic = new StallCharacteristic(halalCertified, muslimOwned,
                vegetarian, inAirconArea);
    }

    public String toString() {
        return "This stall's name is " + name + " and it is:\n" +
                "  " + stallCharacteristic.getHalalCertifiedIcon() + "\n" +
                "  " + stallCharacteristic.getMuslimOwnedIcon() + "\n" +
                "  " + stallCharacteristic.getVegetarianIcon() + "\n" +
                "  " + stallCharacteristic.getInAirconAreaIcon() + "\n";
    }

    public String getName() {
        return name;
    }

    public StallCharacteristic getStallCharacteristic() {
        return stallCharacteristic;
    }
}
