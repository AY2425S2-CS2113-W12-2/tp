package seedu.navi.canteen.canteenfinder.landmark.canteen.stall;

/**
 * The StallCharacteristic class encapsulates the characteristics of a food stall, such as whether it is
 * halal-certified, Muslim-owned, vegetarian-friendly, or located in an air-conditioned area. This class
 * provides methods to retrieve these characteristics and validate them against user-specified criteria.
 * <p>
 * Each characteristic is represented as a boolean value, and the class supports operations to check if
 * a stall matches all or any of the user's criteria.
 *
 * @see #isHalalCertified
 * @see #isMuslimOwned
 * @see #isVegetarian
 * @see #isInAirconArea
 * @see #containsAllFields(String[])
 * @see #containsAnyField(String[])
 */
public class StallCharacteristic {
    private final boolean isHalalCertified;
    private final boolean isMuslimOwned;
    private final boolean isVegetarian;
    private final boolean isInAirconArea;

    /**
     * Constructs a new {@link StallCharacteristic} object with the specified characteristics.
     *
     * @param isHalalCertified A boolean indicating whether the stall is halal-certified.
     * @param isMuslimOwned A boolean indicating whether the stall is Muslim-owned.
     * @param isVegetarian A boolean indicating whether the stall serves vegetarian options.
     * @param isInAirconArea A boolean indicating whether the stall is located in an air-conditioned area.
     */
    public StallCharacteristic(boolean isHalalCertified, boolean isMuslimOwned,
                               boolean isVegetarian, boolean isInAirconArea) {
        this.isHalalCertified = isHalalCertified;
        this.isMuslimOwned = isMuslimOwned;
        this.isVegetarian = isVegetarian;
        this.isInAirconArea = isInAirconArea;
    }

    /**
     * Returns whether the stall is halal-certified.
     *
     * @return A boolean indicating whether the stall is halal-certified.
     */
    public boolean getHalalCertified() {
        return isHalalCertified;
    }

    /**
     * Returns whether the stall is Muslim-owned.
     *
     * @return A boolean indicating whether the stall is Muslim-owned.
     */
    public boolean getMuslimOwned() {
        return isMuslimOwned;
    }

    /**
     * Returns whether the stall serves vegetarian options.
     *
     * @return A boolean indicating whether the stall serves vegetarian options.
     */
    public boolean getVegetarian() {
        return isVegetarian;
    }

    /**
     * Returns whether the stall is located in an air-conditioned area.
     *
     * @return A boolean indicating whether the stall is located in an air-conditioned area.
     */
    public boolean getInAirconArea() {
        return isInAirconArea;
    }

    /**
     * Returns a string representation of the halal certification status with an icon.
     * <p>
     * The icon is "[Y]" if the stall is halal-certified, otherwise "[N]".
     *
     * @return A string representation of the halal certification status.
     */
    public String getHalalCertifiedIcon() {
        String type = "Halal Certified";
        if (isHalalCertified) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    /**
     * Returns a string representation of the Muslim ownership status with an icon.
     * <p>
     * The icon is "[Y]" if the stall is Muslim-owned, otherwise "[N]".
     *
     * @return A string representation of the Muslim ownership status.
     */
    public String getMuslimOwnedIcon() {
        String type = "Muslim Owned";
        if (isMuslimOwned) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    /**
     * Returns a string representation of the vegetarian status with an icon.
     * <p>
     * The icon is "[Y]" if the stall serves vegetarian options, otherwise "[N]".
     *
     * @return A string representation of the vegetarian status.
     */
    public String getVegetarianIcon() {
        String type = "Vegetarian";
        if (isVegetarian) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    /**
     * Returns a string representation of the air-conditioned area status with an icon.
     * <p>
     * The icon is "[Y]" if the stall is located in an air-conditioned area, otherwise "[N]".
     *
     * @return A string representation of the air-conditioned area status.
     */
    public String getInAirconAreaIcon() {
        String type = "In Aircon Area";
        if (isInAirconArea) {
            return "[Y] " + type;
        }
        return "[N] " + type;
    }

    /**
     * Determines whether the stall satisfies all of the user's criteria.
     * <p>
     * This method checks if the stall matches every criterion in the provided array. If any criterion
     * is not satisfied, the method returns false.
     *
     * @param canteenCriteria An array of strings representing the user's canteen criteria.
     * @return A boolean indicating whether the stall satisfies all of the user's criteria.
     */
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

    /**
     * Determines whether the stall satisfies any of the user's criteria.
     * <p>
     * This method checks if the stall matches at least one criterion in the provided array. If any
     * criterion is satisfied, the method returns true.
     *
     * @param canteenCriteria An array of strings representing the user's canteen criteria.
     * @return A boolean indicating whether the stall satisfies any of the user's criteria.
     */
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
