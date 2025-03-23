package seedu.navi.canteenfinder;

import javafx.util.Pair;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.EmptyDietRestriction;
import seedu.navi.exceptions.InvalidDietRestrictions;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.textui.TextUi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CanteenFinder {
    private static final Set<String> validRestrictions = new HashSet<>();

    private static boolean isValidDietRestrictions(String[] dietRestrictions)
            throws IllegalArgumentException {
        // Define the set of valid diet restrictions
        if (validRestrictions.isEmpty()) {
            validRestrictions.add("halal certified");
            validRestrictions.add("muslim owned");
            validRestrictions.add("vegetarian");
            validRestrictions.add("aircon");
            validRestrictions.add("nil");
        }

        Set<String> uniqueRestrictions = new HashSet<>();

        boolean isNILPresent = false;

        for (String dietRestriction : dietRestrictions) {
            String lowerCaseRestriction = dietRestriction.toLowerCase().trim();
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

    private static String[] handleDietRestrictions(String dietRestriction)
            throws EmptyDietRestriction, InvalidDietRestrictions, IllegalArgumentException {
        if (dietRestriction.isEmpty()) {
            throw new EmptyDietRestriction();
        }

        String[] dietRestrictions = dietRestriction.split(", ");
        assert dietRestrictions.length != 0 : "dietRestrictions should not be empty";

        try {
            if (!isValidDietRestrictions(dietRestrictions)) {
                throw new InvalidDietRestrictions();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        if (dietRestrictions[0].trim().equalsIgnoreCase("nil")) {
            dietRestrictions = null;
        }
        return dietRestrictions;
    }

    public static void startCanteenFinder() {
        Scanner in = new Scanner(System.in);
        TextUi.printEnterFunctionCF();
        String[] dietRestrictions;
        String command;
        while (true) {
            command = in.nextLine();
            if (command.trim().equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                dietRestrictions = handleDietRestrictions(command);
            } catch (EmptyDietRestriction e) {
                TextUi.printEmptyDietRestrictionCF();
                continue;
            } catch (InvalidDietRestrictions e ) {
                TextUi.printInvalidDietRestrictionsCF();
                continue;
            } catch (IllegalArgumentException e) {
                TextUi.printNILWithOtherRestrictionsErrorCF();
                continue;
            }

            TextUi.printWhereIsUserCF();
            command = in.nextLine();

            while (command.isEmpty()) {
                TextUi.printEmptyLandmarkCF();
                command = in.nextLine();
            }
            if (command.trim().equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe(command, dietRestrictions);
                TextUi.printNearestCanteenCF(canteenDistPair);
            } catch (LocationNotFound e) {
                TextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                TextUi.printCanteenNotFoundCF();
            }
        }
    }
}
