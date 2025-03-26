package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.helperclasses.NearestCanteenData;
import seedu.navi.canteenfinder.helperclasses.UserShortcuts;
import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;

import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinderParser {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static NearestCanteenData searchLandmark(String landmarkName, String[] dietRestrictions)
            throws CanteenNotFound {
        assert !landmarkName.isEmpty() : "landmarkName should not be empty";
        NearestCanteenData nearestCanteenData = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(landmarkName)) {
                nearestCanteenData = landmark.getNearestCanteen(dietRestrictions);
            }
        }
        if (nearestCanteenData != null) {
            return nearestCanteenData;
        }
        throw new CanteenNotFound();
    }

    public static NearestCanteenData findNearestCanteen(String userLocation, String[] dietRestrictions)
            throws LocationNotFound, CanteenNotFound {
        String landmarkName = UserShortcuts.LANDMARK_MAP.get(userLocation.toLowerCase());
        if (landmarkName == null) {
            throw new LocationNotFound();
        }
        return searchLandmark(landmarkName, dietRestrictions);
    }
}

