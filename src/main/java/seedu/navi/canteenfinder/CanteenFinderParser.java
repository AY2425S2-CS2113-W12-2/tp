package seedu.navi.canteenfinder;

import javafx.util.Pair;
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
        if (canteenValidStallsPair != null) {
            Canteen nearestCanteen = canteenValidStallsPair.getKey();
            Integer landmarkToCanteenDist = userLandmark.getCanteenDistance(nearestCanteen);
            ArrayList<String> validStalls = canteenValidStallsPair.getValue();
            return new NearestCanteenData(nearestCanteen, landmarkToCanteenDist, validStalls);
        }
        throw new CanteenNotFound();
    }

    public static NearestCanteenData findNearestCanteenToMe(String landmark, String[] dietRestrictions)
            throws LocationNotFound, CanteenNotFound {
        NearestCanteenData nearestCanteenData;
        switch (landmark.toLowerCase()) {
        case "soc":
        case "school of computing":
            nearestCanteenData = searchLandmark("SOC", dietRestrictions);
            break;
        case "cde":
        case "college of design and engineering":
            nearestCanteenData = searchLandmark("CDE", dietRestrictions);
            break;
        case "fass":
        case "faculty of arts and social sciences":
            nearestCanteenData = searchLandmark("FASS", dietRestrictions);
            break;
        case "biz":
        case "nus business school":
        case "nbs":
            nearestCanteenData = searchLandmark("NBS", dietRestrictions);
            break;
        case "fos":
        case "faculty of science":
        case "soph":
        case "school of public health":
        case "som":
        case "school of medicine":
            nearestCanteenData = searchLandmark("Science", dietRestrictions);
            break;
        case "raffles hall":
        case "raffles":
            nearestCanteenData = searchLandmark("Raffles", dietRestrictions);
            break;
        case "eusoff hall":
        case "eusoff":
            nearestCanteenData = searchLandmark("Eusoff", dietRestrictions);
            break;
        case "temasek hall":
        case "temasek":
            nearestCanteenData = searchLandmark("Temasek", dietRestrictions);
            break;
        case "sheares hall":
        case "sheares":
            nearestCanteenData = searchLandmark("Sheares", dietRestrictions);
            break;
        case "kent ridge hall":
            nearestCanteenData = searchLandmark("Kent Ridge", dietRestrictions);
            break;
        case "king edward hall":
            nearestCanteenData = searchLandmark("King Edward", dietRestrictions);
            break;
        case "celc":
            nearestCanteenData = searchLandmark("CELC", dietRestrictions);
            break;
        case "hssml":
            nearestCanteenData = searchLandmark("HSSML", dietRestrictions);
            break;
        case "clb":
            nearestCanteenData = searchLandmark("CLB", dietRestrictions);
            break;
        case "msl":
            nearestCanteenData = searchLandmark("MSL", dietRestrictions);
            break;
        case "utown src":
            nearestCanteenData = searchLandmark("UTown SRC", dietRestrictions);
            break;
        case "utown erc":
            nearestCanteenData = searchLandmark("UTown ERC", dietRestrictions);
            break;
        default:
            throw new LocationNotFound();
        }
        return nearestCanteenData;
    }
}
