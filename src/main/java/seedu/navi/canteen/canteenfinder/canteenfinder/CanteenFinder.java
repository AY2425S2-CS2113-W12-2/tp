package seedu.navi.canteen.canteenfinder.canteenfinder;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.canteen.usershortcuts.LandmarkShortcuts;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.EmptyUserLocation;
import seedu.navi.exceptions.HCAndMOCriteriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.exceptions.NILWithOtherCriteria;

import java.util.ArrayList;

/**
 * The CanteenFinder class is responsible for finding the nearest canteen based on user-provided fields.
 * <p>
 * This class uses a list of landmarks to determine the nearest canteen that matches the user's criteria.
 * It validates the user's location, resolves it to a known landmark, and searches for the nearest canteen.
 *
 * @see #LANDMARKS
 * @see #findNearestCanteen(UserFields)
 * @see #searchLandmark(UserFields)
 */
public class CanteenFinder {

    /**
     * A static list of {@link Landmark} objects representing all available landmarks in the system.
     * This list is used to search for the nearest canteen based on the user's location.
     */
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    /**
     * Searches for the nearest canteen within a specific landmark based on the user's criteria.
     * <p>
     * This method iterates through the {@link #LANDMARKS} list to find a matching landmark by name.
     * If a match is found, it retrieves the nearest canteen using the landmark's
     * {@link Landmark#getNearestCanteen(boolean, String[])} method. If no matching landmark or canteen
     * is found, an exception is thrown.
     *
     * @param userFields A {@link UserFields} object containing the user's location and criteria.
     * @return A {@link NearestCanteenData} object containing the nearest canteen, its distance, and valid stalls.
     * @throws CanteenNotFound If no canteen is found within the specified landmark.
     */
    private static NearestCanteenData searchLandmark(UserFields userFields)
            throws CanteenNotFound {
        String landmarkName = userFields.getUserLocation();
        assert !landmarkName.isEmpty() : "landmarkName should not be empty";
        NearestCanteenData nearestCanteenData = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(landmarkName)) {
                nearestCanteenData = landmark.getNearestCanteen(userFields.isOrSearchType(),
                        userFields.getCanteenCriteria());
            }
        }
        if (nearestCanteenData != null) {
            assert nearestCanteenData.nearestCanteen() != null ||
                    nearestCanteenData.canteenDistance() != null ||
                    nearestCanteenData.validStalls() != null :
                    "all nearestCanteenData fields should not be null";
            return nearestCanteenData;
        }
        throw new CanteenNotFound();
    }

    /**
     * Finds the nearest canteen based on the user's input fields.
     * <p>
     * This method resolves the user's location to a known landmark using the {@link LandmarkShortcuts#LANDMARK_MAP}.
     * If the location is invalid, an exception is thrown. Otherwise, the resolved landmark is used to search
     * for the nearest canteen by delegating to {@link #searchLandmark(UserFields)}.
     *
     * @param userFields A {@link UserFields} object containing the user's location and criteria.
     * @return A {@link NearestCanteenData} object containing the nearest canteen, its distance, and valid stalls.
     * @throws LocationNotFound If the user's location cannot be resolved to a known landmark.
     * @throws CanteenNotFound If no canteen is found within the resolved landmark.
     * @throws InvalidCanteenCriteria If the user's canteen criteria are invalid.
     * @throws NILWithOtherCriteria If "NIL" is used with other criteria.
     * @throws DuplicateCanteenCriterion If duplicate criteria are detected.
     * @throws HCAndMOCriteriaError If both "Halal Certified" and "Muslim Owned" criteria are used together.
     * @throws EmptyUserLocation If the user's location is empty.
     * @see LandmarkShortcuts#LANDMARK_MAP
     * @see #searchLandmark(UserFields)
     */
    public static NearestCanteenData findNearestCanteen(UserFields userFields)
            throws LocationNotFound, CanteenNotFound, InvalidCanteenCriteria, NILWithOtherCriteria,
            DuplicateCanteenCriterion, HCAndMOCriteriaError, EmptyUserLocation {
        String landmarkName = LandmarkShortcuts.LANDMARK_MAP.get(userFields.getUserLocation().toLowerCase());
        if (landmarkName == null) {
            throw new LocationNotFound();
        }
        userFields.setUserLocation(landmarkName);
        return searchLandmark(userFields);
    }
}
