package seedu.navi.canteen.canteenfinder.userfields;

/**
 * The UserFields class encapsulates the user-provided fields required for the Canteen Finder module.
 * <p>
 * This class stores information about the search type (OR or AND), the user's location, and the
 * canteen criteria. It provides getter and setter methods to access and modify these fields.
 *
 * @see #isOrSearchType
 * @see #userLocation
 * @see #canteenCriteria
 */
public class UserFields {
    private boolean isOrSearchType;
    private String userLocation;
    private String[] canteenCriteria;
    /**
     * Constructs a new {@link UserFields} object with the specified search type, user location,
     * and canteen criteria.
     *
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @param userLocation The user's location as a string.
     * @param canteenCriteria An array of canteen criteria strings.
     */
    public UserFields(boolean isOrSearchType, String userLocation, String[] canteenCriteria) {
        this.isOrSearchType = isOrSearchType;
        this.userLocation = userLocation;
        this.canteenCriteria = canteenCriteria;
    }
    /**
     * Returns the search type as a boolean.
     * <p>
     * This method indicates whether the search is OR-based (true) or AND-based (false).
     *
     * @return A boolean representing the search type.
     */
    public boolean isOrSearchType() {
        return isOrSearchType;
    }
    /**
     * Sets the search type to the specified value.
     *
     * @param orSearchType A boolean indicating whether the search is OR-based (true) or
     *                     AND-based (false).
     */
    public void setOrSearchType(boolean orSearchType) {
        isOrSearchType = orSearchType;
    }
    /**
     * Returns the user's location as a string.
     *
     * @return A string representing the user's location.
     */
    public String getUserLocation() {
        return userLocation;
    }
    /**
     * Sets the user's location to the specified value.
     *
     * @param userLocation A string representing the user's location.
     */
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
    /**
     * Returns the array of canteen criteria strings.
     *
     * @return An array of strings representing the canteen criteria.
     */
    public String[] getCanteenCriteria() {
        return canteenCriteria;
    }
    /**
     * Sets the canteen criteria to the specified array of strings.
     *
     * @param canteenCriteria An array of strings representing the canteen criteria.
     */
    public void setCanteenCriteria(String[] canteenCriteria) {
        this.canteenCriteria = canteenCriteria;
    }
}
