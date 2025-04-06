package seedu.navi.canteen.canteenfinder.landmark.canteen.stall;

public class StallCharacteristic {
    private final boolean isHalalCertified;
    private final boolean isMuslimOwned;
    private final boolean isVegetarian;
    private final boolean isInAirconArea;

    public StallCharacteristic(boolean isHalalCertified, boolean isMuslimOwned,
                               boolean isVegetarian, boolean isInAirconArea) {
        this.isHalalCertified = isHalalCertified;
        this.isMuslimOwned = isMuslimOwned;
        this.isVegetarian = isVegetarian;
        this.isInAirconArea = isInAirconArea;
    }

    public boolean getHalalCertified() {
        return isHalalCertified;
    }

    public boolean getMuslimOwned() {
        return isMuslimOwned;
    }

    public boolean getVegetarian() {
        return isVegetarian;
    }

    public boolean getInAirconArea() {
        return isInAirconArea;
    }

    public String getHalalCertifiedIcon() {
        String type = "Halal Certified";
        if (isHalalCertified) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getMuslimOwnedIcon() {
        String type = "Muslim Owned";
        if (isMuslimOwned) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getVegetarianIcon() {
        String type = "Vegetarian";
        if (isVegetarian) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    public String getInAirconAreaIcon() {
        String type = "In Aircon Area";
        if (isInAirconArea) {
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
                if (!isHalalCertified) {
                    return false;
                }
                break;
            case "muslim owned":
                if (!isMuslimOwned) {
                    return false;
                }
                break;
            case "vegetarian":
                if (!isVegetarian) {
                    return false;
                }
                break;
            case "aircon":
                if (!isInAirconArea) {
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
            return true;
        }
        for (String canteenCriterion : canteenCriteria) {
            assert canteenCriterion.equalsIgnoreCase("halal certified") ||
                    canteenCriterion.equalsIgnoreCase("muslim owned") ||
                    canteenCriterion.equalsIgnoreCase("vegetarian") ||
                    canteenCriterion.equalsIgnoreCase("aircon") : "Invalid canteen criterion";

            switch (canteenCriterion.toLowerCase()) {
            case "halal certified":
                if (isHalalCertified) {
                    return true;
                }
                break;
            case "muslim owned":
                if (isMuslimOwned) {
                    return true;
                }
                break;
            case "vegetarian":
                if (isVegetarian) {
                    return true;
                }
                break;
            case "aircon":
                if (isInAirconArea) {
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
