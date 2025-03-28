package seedu.navi.canteen.canteenfinder;

import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.canteen.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.EmptyCanteenCriteria;
import seedu.navi.exceptions.HCAndMOCrtieriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.exceptions.NILWithOtherCriteria;
import seedu.navi.textui.TextUi;

public class CanteenFinder {

    public static void startCanteenFinder() {
        TextUi.printCanteenFinderGreetingCF();
        String[] canteenCriteria;
        String command;
        while (true) {
            command = TextUi.IN.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                canteenCriteria = CanteenCriterionParser.handleCanteenCriterion(command);
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

            assert canteenCriteria == null || canteenCriteria.length > 0 :
                    "Output canteenCriteria should either be null or non-empty.";

            TextUi.printAcknowledgeUserCriteriaCF(canteenCriteria);
            command = TextUi.IN.nextLine().trim();

            while (command.isEmpty()) {
                TextUi.printEmptyLandmarkCF();
                command = TextUi.IN.nextLine().trim();
            }
            if (command.equalsIgnoreCase("exit")) {
                TextUi.printExitCanteenFinderCF();
                break;
            }
            try {
                NearestCanteenData nearestCanteenData =
                        CanteenFinderParser.findNearestCanteen(command, canteenCriteria);
                TextUi.printNearestCanteenCF(nearestCanteenData);
            } catch (LocationNotFound e) {
                TextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                TextUi.printCanteenNotFoundCF();
            }
        }
    }
}

