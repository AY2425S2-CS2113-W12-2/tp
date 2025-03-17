package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;
import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinder {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static Canteen searchLandmark(String userLocation, String[] dietRestrictions)
            throws CanteenNotFound {
        assert !userLocation.isEmpty() : "userLocation should not be empty";
        Canteen nearestCanteen = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(userLocation)) {
                nearestCanteen = landmark.getNearestCanteen(dietRestrictions);
            }
        }
        if (nearestCanteen != null) {
            return nearestCanteen;
        }
        throw new CanteenNotFound();
    }

    public static Canteen findNearestCanteenToMe(String landmark, String[] dietRestrictions)
            throws LocationNotFound, CanteenNotFound {
        Canteen nearestCanteen;
        switch (landmark.toLowerCase()) {
        case "soc":
        case "school of computing":
            nearestCanteen = searchLandmark("SOC", dietRestrictions);
            break;
        case "cde":
        case "college of design and engineering":
            nearestCanteen = searchLandmark("CDE", dietRestrictions);
            break;
        case "fass":
        case "faculty of arts and social sciences":
            nearestCanteen = searchLandmark("FASS", dietRestrictions);
            break;
        case "biz":
        case "nus business school":
        case "nbs":
            nearestCanteen = searchLandmark("NBS", dietRestrictions);
            break;
        case "fos":
        case "faculty of science":
        case "soph":
        case "school of public health":
        case "som":
        case "school of medicine":
            nearestCanteen = searchLandmark("Science", dietRestrictions);
            break;
        case "raffles hall":
        case "raffles":
            nearestCanteen = searchLandmark("Raffles", dietRestrictions);
            break;
        case "eusoff hall":
        case "eusoff":
            nearestCanteen = searchLandmark("Eusoff", dietRestrictions);
            break;
        case "temasek hall":
        case "temasek":
            nearestCanteen = searchLandmark("Temasek", dietRestrictions);
            break;
        case "sheares hall":
        case "sheares":
            nearestCanteen = searchLandmark("Sheares", dietRestrictions);
            break;
        case "kent ridge hall":
            nearestCanteen = searchLandmark("Kent Ridge", dietRestrictions);
            break;
        case "king edward hall":
            nearestCanteen = searchLandmark("King Edward", dietRestrictions);
            break;
        case "celc":
            nearestCanteen = searchLandmark("CELC", dietRestrictions);
            break;
        case "hssml":
            nearestCanteen = searchLandmark("HSSML", dietRestrictions);
            break;
        case "clb":
            nearestCanteen = searchLandmark("CLB", dietRestrictions);
            break;
        case "msl":
            nearestCanteen = searchLandmark("MSL", dietRestrictions);
            break;
        case "utown src":
            nearestCanteen = searchLandmark("UTown SRC", dietRestrictions);
            break;
        case "utown erc":
            nearestCanteen = searchLandmark("UTown ERC", dietRestrictions);
            break;
        default:
            throw new LocationNotFound();
        }
        return nearestCanteen;
    }
}
