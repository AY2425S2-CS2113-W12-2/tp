package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.LandmarkNotInStorage;
import seedu.navi.exceptions.LocationNotFound;

import java.util.ArrayList;

// main class for canteen finder feature
public class CanteenFinder {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static Canteen searchSOC() {
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals("SOC")) {
                ArrayList<Canteen> nearestCanteens = landmark.getNearestCanteens();
                return nearestCanteens.get(0);
            }
        }
        throw new LandmarkNotInStorage();
    }

    private static Canteen searchCDE() {
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals("CDE")) {
                ArrayList<Canteen> nearestCanteens = landmark.getNearestCanteens();
                return nearestCanteens.get(0);
            }
        }
        throw new LandmarkNotInStorage();
    }

    private static Canteen searchFASS() {
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals("FASS")) {
                ArrayList<Canteen> nearestCanteens = landmark.getNearestCanteens();
                return nearestCanteens.get(0);
            }
        }
        throw new LandmarkNotInStorage();
    }

    private static Canteen searchNBS() {
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals("NBS")) {
                ArrayList<Canteen> nearestCanteens = landmark.getNearestCanteens();
                return nearestCanteens.get(0);
            }
        }
        throw new LandmarkNotInStorage();
    }

    private static Canteen searchScience() {
        for (Landmark landmark : LANDMARKS) {
            if (landmark.getName().equals("Science")) {
                ArrayList<Canteen> nearestCanteens = landmark.getNearestCanteens();
                return nearestCanteens.get(0);
            }
        }
        throw new LandmarkNotInStorage();
    }

    public static Canteen findNearestCanteenToMe(String landmark) {
        Canteen nearestCanteen;
        switch (landmark.toLowerCase()) {
        case "soc":
        case "school of computing":
            nearestCanteen = searchSOC();
            break;
        case "cde":
        case "college of design and engineering":
            nearestCanteen = searchCDE();
            break;
        case "fass":
        case "faculty of arts and social sciences":
            nearestCanteen = searchFASS();
            break;
        case "biz":
        case "nus business school":
        case "nbs":
            nearestCanteen = searchNBS();
            break;
        case "fos":
        case "faculty of science":
        case "soph":
        case "school of public health":
        case "som":
        case "school of medicine":
            nearestCanteen = searchScience();
            break;
        default:
            throw new LocationNotFound();
        }
        //TextUi.printNearestCanteen(nearestCanteen);
        return nearestCanteen;
    }
}
