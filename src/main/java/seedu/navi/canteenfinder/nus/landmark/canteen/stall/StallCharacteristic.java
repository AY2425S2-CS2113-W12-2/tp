package seedu.navi.canteenfinder.nus.landmark.canteen.stall;

public class StallCharacteristic {
    private final boolean halalCertified;
    private final boolean muslimOwned;
    private final boolean vegetarian;
    private final boolean inAirconArea;

    public StallCharacteristic() {
        this(false, false, false, false);
    }

    public StallCharacteristic(boolean halalCertified, boolean muslimOwned,
                               boolean vegetarian, boolean inAirconArea) {
        this.halalCertified = halalCertified;
        this.muslimOwned = muslimOwned;
        this.vegetarian = vegetarian;
        this.inAirconArea = inAirconArea;
    }

    //test code
    /*
    public boolean getHalalCertified() {
        return halalCertified;
    }

    public boolean getMuslimOwned() {
        return muslimOwned;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public boolean getInAirconArea() {
        return inAirconArea;
    }
 */
    public String getHalalCertifiedIcon() {
        String type = "Halal Certified";
        if (halalCertified) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getMuslimOwnedIcon() {
        String type = "Muslim Owned";
        if (muslimOwned) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getVegetarianIcon() {
        String type = "Vegetarian";
        if (vegetarian) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getInAirconAreaIcon() {
        String type = "In Aircon Area";
        if (inAirconArea) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

}
