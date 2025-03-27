package seedu.navi.canteenfinder;

import seedu.navi.canteenfinder.helperclasses.DietRestrictionParser;
import seedu.navi.canteenfinder.helperclasses.NearestCanteenData;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.EmptyDietRestriction;
import seedu.navi.exceptions.InvalidDietRestrictions;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.textui.TextUi;

import java.util.Scanner;

public class CanteenFinder {

    public static void startCanteenFinder() {
        Scanner in = new Scanner(System.in);
        TextUi.printEnterFunctionCF();
        String[] dietRestrictions;
        String command;
        while (true) {
            command = in.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                dietRestrictions = DietRestrictionParser.handleDietRestrictions(command);
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
            command = in.nextLine().trim();

            while (command.isEmpty()) {
                TextUi.printEmptyLandmarkCF();
                command = in.nextLine().trim();
            }
            if (command.equalsIgnoreCase("exit")) {
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

