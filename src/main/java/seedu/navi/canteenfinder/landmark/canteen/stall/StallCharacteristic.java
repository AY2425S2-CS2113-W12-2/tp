package seedu.navi.canteenfinder.landmark.canteen.stall;

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

    public boolean containsFields(String[] dietRestrictions) {
        if (dietRestrictions == null) {
            return true;
        }
        for (String dietRestriction : dietRestrictions) {
            switch (dietRestriction.toLowerCase()) {
            case "halal certified":
                if (!halalCertified) {
                    return false;
                }
                break;
            case "muslim owned":
                if (!muslimOwned) {
                    return false;
                }
                break;
            case "vegetarian":
                if (!vegetarian) {
                    return false;
                }
                break;
            case "in aircon area":
                if (!inAirconArea) {
                    return false;
                }
                break;
            }
        }
        return true;
    }
}
