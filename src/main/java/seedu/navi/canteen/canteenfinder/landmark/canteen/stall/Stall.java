package seedu.navi.canteen.canteenfinder.landmark.canteen.stall;

/**
 * The Stall class represents a food stall within a canteen. It stores information about the stall's
 * name and its characteristics, such as whether it is halal-certified, vegetarian-friendly, or located
 * in an air-conditioned area. This class provides methods to validate stalls based on user-specified
 * criteria and retrieve their characteristics.
 * <p>
 * Each stall has a unique name and a set of characteristics encapsulated in a {@link StallCharacteristic}
 * object. The class supports operations to check if a stall matches the user's search type (OR or AND)
 * and criteria.
 *
 * @see #name
 * @see #stallCharacteristic
 * @see #isValidStall(boolean, String[])
 */
public class Stall {
    private final String name;
    private final StallCharacteristic stallCharacteristic;

    /**
     * Constructs a new {@link Stall} object with the specified name and characteristics.
     *
     * @param name The name of the stall.
     * @param halalCertified A boolean indicating whether the stall is halal-certified.
     * @param muslimOwned A boolean indicating whether the stall is Muslim-owned.
     * @param vegetarian A boolean indicating whether the stall serves vegetarian options.
     * @param inAirconArea A boolean indicating whether the stall is located in an air-conditioned area.
     */
    public Stall(String name, boolean halalCertified, boolean muslimOwned,
                 boolean vegetarian, boolean inAirconArea) {
        this.name = name;
        stallCharacteristic = new StallCharacteristic(halalCertified, muslimOwned,
                vegetarian, inAirconArea);
    }

    /**
     * Returns a string representation of the stall, including its name and characteristics.
     * <p>
     * The string includes icons for each characteristic, such as halal certification, vegetarian options,
     * and air-conditioned status.
     *
     * @return A string representation of the stall.
     */
    public String toString() {
        return name + "\n" +
                "  " + stallCharacteristic.getHalalCertifiedIcon() + "\n" +
                "  " + stallCharacteristic.getMuslimOwnedIcon() + "\n" +
                "  " + stallCharacteristic.getVegetarianIcon() + "\n" +
                "  " + stallCharacteristic.getInAirconAreaIcon() + "\n";
    }

    /**
     * Returns the name of the stall.
     *
     * @return A string representing the name of the stall.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the characteristics of the stall.
     *
     * @return A {@link StallCharacteristic} object representing the stall's characteristics.
     */
    public StallCharacteristic getStallCharacteristic() {
        return stallCharacteristic;
    }

    /**
     * Determines whether the stall is valid based on the user's criteria.
     * <p>
     * This method checks if the stall satisfies the user's search type (OR or AND) and criteria. For OR-based
     * searches, the stall is valid if it matches any of the criteria. For AND-based searches, the stall must
     * match all the criteria.
     *
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @param canteenCriteria An array of strings representing the user's canteen criteria.
     * @return A boolean indicating whether the stall is valid based on the user's criteria.
     * @see StallCharacteristic#containsAnyField(String[])
     * @see StallCharacteristic#containsAllFields(String[])
     */
    public boolean isValidStall(boolean isOrSearchType, String[] canteenCriteria) {
        assert stallCharacteristic != null : "stallCharacteristic should not be null";
        if (isOrSearchType) {
            return stallCharacteristic.containsAnyField(canteenCriteria);
        }
        return stallCharacteristic.containsAllFields(canteenCriteria);
    }
}
