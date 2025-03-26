package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.helperclasses.NearestCanteenData;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.EmptyDietRestriction;
import seedu.navi.exceptions.InvalidDietRestrictions;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.textui.TextUi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CanteenFinder {
    private static final Set<String> VALID_RESTRICTIONS = new HashSet<>();

    private static boolean isValidDietRestrictions(String[] dietRestrictions)
            throws IllegalArgumentException {
        // Define the set of valid diet restrictions
        if (VALID_RESTRICTIONS.isEmpty()) {
            VALID_RESTRICTIONS.add("halal certified");
            VALID_RESTRICTIONS.add("muslim owned");
            VALID_RESTRICTIONS.add("vegetarian");
            VALID_RESTRICTIONS.add("aircon");
            VALID_RESTRICTIONS.add("nil");
        }
        Set<String> uniqueRestrictions = new HashSet<>();

        boolean isNILPresent = false;

        for (String dietRestriction : dietRestrictions) {
            String lowerCaseRestriction = dietRestriction.toLowerCase().trim();
            if (!VALID_RESTRICTIONS.contains(lowerCaseRestriction)) {
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
                NearestCanteenData nearestCanteenData =
                        CanteenFinderParser.findNearestCanteen(command, dietRestrictions);
                TextUi.printNearestCanteenCF(nearestCanteenData);
            } catch (LocationNotFound e) {
                TextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                TextUi.printCanteenNotFoundCF();
            }
        }
    }
}

