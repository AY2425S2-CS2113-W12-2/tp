package seedu.navi.canteen.canteenfinder.canteenfinderparser;

import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.canteen.canteenfinder.usershortcuts.LandmarkShortcuts;
import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;

import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinderParser {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static NearestCanteenData searchLandmark(String landmarkName, String[] canteenCriteria)
            throws CanteenNotFound {
        assert !landmarkName.isEmpty() : "landmarkName should not be empty";
        NearestCanteenData nearestCanteenData = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(landmarkName)) {
                nearestCanteenData = landmark.getNearestCanteen(canteenCriteria);
            }
        }
        if (nearestCanteenData != null) {
            return nearestCanteenData;
        }
        throw new CanteenNotFound();
    }

    public static NearestCanteenData findNearestCanteen(String userLocation, String[] canteenCriteria)
            throws LocationNotFound, CanteenNotFound {
        String landmarkName = LandmarkShortcuts.LANDMARK_MAP.get(userLocation.toLowerCase());
        if (landmarkName == null) {
            throw new LocationNotFound();
        }
        return searchLandmark(landmarkName, canteenCriteria);
    }
}

