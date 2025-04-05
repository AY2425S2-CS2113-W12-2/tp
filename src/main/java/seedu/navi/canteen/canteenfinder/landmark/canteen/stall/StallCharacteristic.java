package seedu.navi.canteen.canteenfinder.landmark.canteen.stall;

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

    public boolean containsAllFields(String[] canteenCriteria) {
        if (canteenCriteria == null) {
            return true;
        }
        for (String canteenCriterion : canteenCriteria) {
            assert canteenCriterion.equalsIgnoreCase("halal certified") ||
                    canteenCriterion.equalsIgnoreCase("muslim owned") ||
                    canteenCriterion.equalsIgnoreCase("vegetarian") ||
                    canteenCriterion.equalsIgnoreCase("aircon") : "Invalid canteen criterion";

            switch (canteenCriterion.toLowerCase()) {
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
            case "aircon":
                if (!inAirconArea) {
                    return false;
                }
                break;
            default:
            }
        }
        return true;
    }

    public boolean containsAnyField(String[] canteenCriteria) {
        if (canteenCriteria == null) {
            return false;
        }
        for (String canteenCriterion : canteenCriteria) {
            assert canteenCriterion.equalsIgnoreCase("halal certified") ||
                    canteenCriterion.equalsIgnoreCase("muslim owned") ||
                    canteenCriterion.equalsIgnoreCase("vegetarian") ||
                    canteenCriterion.equalsIgnoreCase("aircon") : "Invalid canteen criterion";

            switch (canteenCriterion.toLowerCase()) {
            case "halal certified":
                if (halalCertified) {
                    return true;
                }
                break;
            case "muslim owned":
                if (muslimOwned) {
                    return true;
                }
                break;
            case "vegetarian":
                if (vegetarian) {
                    return true;
                }
                break;
            case "aircon":
                if (inAirconArea) {
                    return true;
                }
                break;
            default:
                break;
            }
        }
        return false;
    }
}
