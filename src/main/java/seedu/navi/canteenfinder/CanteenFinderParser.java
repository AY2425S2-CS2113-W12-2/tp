package seedu.navi.canteenfinder;

import javafx.util.Pair;
import seedu.navi.canteenfinder.helperclasses.NearestCanteenData;
import seedu.navi.canteenfinder.helperclasses.UserShortcuts;
import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;
import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinderParser {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static NearestCanteenData searchLandmark(String userLocation, String[] dietRestrictions)
            throws CanteenNotFound {
        assert !userLocation.isEmpty() : "userLocation should not be empty";
        Pair<Canteen, ArrayList<String>> canteenValidStallsPair = null;
        Landmark userLandmark = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(userLocation)) {
                canteenValidStallsPair = landmark.getNearestCanteen(dietRestrictions);
                userLandmark = landmark;
            }
        }
        assert userLandmark != null : "userLandmark should always find a valid landmark";
        if (canteenValidStallsPair != null) {
            Canteen nearestCanteen = canteenValidStallsPair.getKey();
            int landmarkToCanteenDist = userLandmark.getCanteenDistance(nearestCanteen);
            assert landmarkToCanteenDist != -1 : "landmarkToCanteenDist should always have a valid distance";
            ArrayList<String> validStalls = canteenValidStallsPair.getValue();
            return new NearestCanteenData(nearestCanteen, landmarkToCanteenDist, validStalls);
        }
        throw new CanteenNotFound();
    }

    public static NearestCanteenData findNearestCanteenToMe(String landmark, String[] dietRestrictions)
            throws LocationNotFound, CanteenNotFound {
        String normalisedLandmark = landmark.toLowerCase();
        String searchKey = UserShortcuts.LANDMARK_MAP.get(normalisedLandmark);
        if (searchKey == null) {
            throw new LocationNotFound();
        }
        return searchLandmark(searchKey, dietRestrictions);
    }
}
