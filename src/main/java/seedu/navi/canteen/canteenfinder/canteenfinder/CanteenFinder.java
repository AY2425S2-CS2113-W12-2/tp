package seedu.navi.canteen.canteenfinder.canteenfinder;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.canteen.usershortcuts.LandmarkShortcuts;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.EmptyUserLocation;
import seedu.navi.exceptions.HCAndMOCrtieriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.exceptions.NILWithOtherCriteria;

import java.util.ArrayList;

public class CanteenFinder {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

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
                    nearestCanteenData.landmarkToCanteenDist() != null ||
                    nearestCanteenData.validStalls() != null :
                    "all nearestCanteenData fields should not be null";
            return nearestCanteenData;
        }
        throw new CanteenNotFound();
    }

    public static NearestCanteenData findNearestCanteen(UserFields userFields)
            throws LocationNotFound, CanteenNotFound, InvalidCanteenCriteria, NILWithOtherCriteria,
            DuplicateCanteenCriterion, HCAndMOCrtieriaError, EmptyUserLocation {
        String landmarkName = LandmarkShortcuts.LANDMARK_MAP.get(userFields.getUserLocation().toLowerCase());
        if (landmarkName == null) {
            throw new LocationNotFound();
        }
        userFields.setUserLocation(landmarkName);
        return searchLandmark(userFields);
    }
}
