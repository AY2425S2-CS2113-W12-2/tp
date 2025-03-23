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

    private static Pair<Canteen, Integer> searchLandmark(String userLocation, String[] dietRestrictions)
            throws CanteenNotFound {
        assert !userLocation.isEmpty() : "userLocation should not be empty";
        Canteen nearestCanteen = null;
        Integer landmarkToCanteenDist = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(userLocation)) {
                nearestCanteen = landmark.getNearestCanteen(dietRestrictions);
                landmarkToCanteenDist = landmark.getCanteenDistance(nearestCanteen);
            }
        }
        if (nearestCanteen != null) {
            return new Pair<>(nearestCanteen, landmarkToCanteenDist);
        }
        throw new CanteenNotFound();
    }

    public static Pair<Canteen, Integer> findNearestCanteenToMe(String landmark, String[] dietRestrictions)
            throws LocationNotFound, CanteenNotFound {
        Pair<Canteen, Integer> canteenDistPair;
        switch (landmark.toLowerCase()) {
        case "soc":
        case "school of computing":
            canteenDistPair = searchLandmark("SOC", dietRestrictions);
            break;
        case "cde":
        case "college of design and engineering":
            canteenDistPair = searchLandmark("CDE", dietRestrictions);
            break;
        case "fass":
        case "faculty of arts and social sciences":
            canteenDistPair = searchLandmark("FASS", dietRestrictions);
            break;
        case "biz":
        case "nus business school":
        case "nbs":
            canteenDistPair = searchLandmark("NBS", dietRestrictions);
            break;
        case "fos":
        case "faculty of science":
        case "soph":
        case "school of public health":
        case "som":
        case "school of medicine":
            canteenDistPair = searchLandmark("Science", dietRestrictions);
            break;
        case "raffles hall":
        case "raffles":
            canteenDistPair = searchLandmark("Raffles", dietRestrictions);
            break;
        case "eusoff hall":
        case "eusoff":
            canteenDistPair = searchLandmark("Eusoff", dietRestrictions);
            break;
        case "temasek hall":
        case "temasek":
            canteenDistPair = searchLandmark("Temasek", dietRestrictions);
            break;
        case "sheares hall":
        case "sheares":
            canteenDistPair = searchLandmark("Sheares", dietRestrictions);
            break;
        case "kent ridge hall":
            canteenDistPair = searchLandmark("Kent Ridge", dietRestrictions);
            break;
        case "king edward hall":
            canteenDistPair = searchLandmark("King Edward", dietRestrictions);
            break;
        case "celc":
            canteenDistPair = searchLandmark("CELC", dietRestrictions);
            break;
        case "hssml":
            canteenDistPair = searchLandmark("HSSML", dietRestrictions);
            break;
        case "clb":
            canteenDistPair = searchLandmark("CLB", dietRestrictions);
            break;
        case "msl":
            canteenDistPair = searchLandmark("MSL", dietRestrictions);
            break;
        case "utown src":
            canteenDistPair = searchLandmark("UTown SRC", dietRestrictions);
            break;
        case "utown erc":
            canteenDistPair = searchLandmark("UTown ERC", dietRestrictions);
            break;
        default:
            throw new LocationNotFound();
        }
        return canteenDistPair;
    }
}
