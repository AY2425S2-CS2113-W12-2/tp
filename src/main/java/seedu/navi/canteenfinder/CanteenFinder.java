package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.LandmarkNotInStorage;
import seedu.navi.exceptions.LocationNotFound;

import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinder {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static Canteen searchFaculty(String userLocation, String[] dietRestrictions) {
        Canteen nearestCanteen = null;
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals(userLocation)) {
                nearestCanteen = landmark.getNearestCanteen(dietRestrictions);
            }
        }
        if (nearestCanteen != null) {
            return nearestCanteen;
        }
        throw new LandmarkNotInStorage();
    }

    public static Canteen findNearestCanteenToMe(String landmark, String[] dietRestrictions) {
        Canteen nearestCanteen;
        switch (landmark.toLowerCase()) {
        case "soc":
        case "school of computing":
            nearestCanteen = searchFaculty("SOC", dietRestrictions);
            break;
        case "cde":
        case "college of design and engineering":
            nearestCanteen = searchFaculty("CDE", dietRestrictions);
            break;
        case "fass":
        case "faculty of arts and social sciences":
            nearestCanteen = searchFaculty("FASS", dietRestrictions);
            break;
        case "biz":
        case "nus business school":
        case "nbs":
            nearestCanteen = searchFaculty("NBS", dietRestrictions);
            break;
        case "fos":
        case "faculty of science":
        case "soph":
        case "school of public health":
        case "som":
        case "school of medicine":
            nearestCanteen = searchFaculty("Science", dietRestrictions);
            break;
        default:
            throw new LocationNotFound();
        }
        //TextUi.printNearestCanteen(nearestCanteen);
        return nearestCanteen;
    }
}
