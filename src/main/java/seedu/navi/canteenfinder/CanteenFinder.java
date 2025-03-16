package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.textui.TextUi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// main class for canteen finder feature
public class CanteenFinder {
    public static final ArrayList<Landmark> LANDMARKS = new ArrayList<>();

    private static Canteen searchLandmark(String userLocation, String[] dietRestrictions)
            throws CanteenNotFound {
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

    public static boolean isValidDietRestrictions(String[] dietRestrictions) {
        // Define the set of valid diet restrictions
        Set<String> validRestrictions = new HashSet<>();
        validRestrictions.add("halal certified");
        validRestrictions.add("muslim owned");
        validRestrictions.add("vegetarian");
        validRestrictions.add("aircon");
        validRestrictions.add("nil");

        // Use a set to track unique restrictions
        Set<String> uniqueRestrictions = new HashSet<>();

        boolean isNILPresent = false;

        // Iterate through the diet restrictions
        for (String dietRestriction : dietRestrictions) {
            // Convert to lower case for case-insensitive comparison
            String lowerCaseRestriction = dietRestriction.toLowerCase().trim();

            // Check if the restriction is valid
            if (!validRestrictions.contains(lowerCaseRestriction)) {
                return false;
            }

            // Check for duplicates
            if (!uniqueRestrictions.add(lowerCaseRestriction)) {
                return false;
            }

            if ("nil".equals(lowerCaseRestriction)) {
                isNILPresent = true;
            }
        }
        if (isNILPresent && uniqueRestrictions.size() > 1) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void canteenFinderParser() {
        Scanner in = new Scanner(System.in);
        TextUi.printEnterFunctionCF();
        Canteen nearestCanteen;
        while (true) {
            String dietRestriction = in.nextLine();
            if (dietRestriction.isEmpty()) {
                TextUi.printEmptyDietRestrictionCF();
                continue;
            }
            String[] dietRestrictions = dietRestriction.split(", ");
            try {
                if (!isValidDietRestrictions(dietRestrictions)) {
                    TextUi.printIsNotValidDietRestrictionsCF();
                    continue;
                }
            } catch (IllegalArgumentException e) {
                TextUi.printNILWithOtherRestrictionsErrorCF();
                continue;
            }
            if (dietRestrictions[0].equalsIgnoreCase("nil")) {
                dietRestrictions = null;
            }
            TextUi.printWhereIsUserCF();
            String landmark = in.nextLine();
            while (landmark.isEmpty()) {
                TextUi.printEmptyLandmarkCF();
                landmark = in.nextLine();
            }
            try {
                nearestCanteen = findNearestCanteenToMe(landmark, dietRestrictions);
                TextUi.printNearestCanteenCF(nearestCanteen);
            } catch (LocationNotFound e) {
                TextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                TextUi.printCanteenNotFoundCF();
            }
            break;
        }
    }
}
