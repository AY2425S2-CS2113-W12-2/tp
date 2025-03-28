package seedu.navi.canteen.canteenfinder;

import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.canteen.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.exceptions.*;
import seedu.navi.textui.TextUi;

import java.util.Scanner;

public class CanteenFinder {

    public static void startCanteenFinder() {
        Scanner in = new Scanner(System.in);
        TextUi.printEnterFunctionCF();
        String[] canteenCriterion;
        String command;
        while (true) {
            command = in.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                canteenCriterion = CanteenCriterionParser.handleCanteenCriterion(command);
            } catch (EmptyCanteenCriteria e) {
                TextUi.printEmptyCanteenCriteriaCF();
                continue;
            } catch (InvalidCanteenCriteria e) {
                TextUi.printInvalidCanteenCriteriaCF();
                continue;
            } catch (NILWithOtherCriteria e) {
                TextUi.printNILWithOtherCriteriaErrorCF();
                continue;
            } catch (DuplicateCanteenCriterion e) {
                TextUi.printDuplicateCanteenCriteriaCF();
                continue;
            } catch (HCAndMOCrtieriaError e) {
                TextUi.printHCAndMOCriteriaErrorCF();
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
                        CanteenFinderParser.findNearestCanteen(command, canteenCriterion);
                TextUi.printNearestCanteenCF(nearestCanteenData);
            } catch (LocationNotFound e) {
                TextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                TextUi.printCanteenNotFoundCF();
            }
        }
    }
}

