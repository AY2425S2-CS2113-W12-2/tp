package seedu.navi.canteen.canteenfinder;

import seedu.navi.canteen.canteenfinder.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.HCAndMOCriteriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.InvalidSearchType;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.exceptions.MissingCanteenFinderFields;
import seedu.navi.exceptions.NILWithOtherCriteria;
import seedu.navi.textui.CanteenFinderTextUi;
import seedu.navi.textui.NaviTextUi;

/**
 * The CanteenFinderStartup class serves as the entry point for the Canteen Finder module.
 * It handles user input, processes commands, and interacts with the Canteen Finder system
 * to find the nearest canteen based on user-specified criteria.
 */
public class CanteenFinderStartup {

    /**
     * Starts the Canteen Finder application and enters an loop where users can
     * input commands to search for the nearest canteen. The method continuously prompts the
     * user for input until the user explicitly exits the program by entering "e" or "exit".
     * <p>
     * This method always runs in a loop, processing user commands and providing feedback
     * based on the validity of the input and the results of the canteen search. It delegates
     * the parsing of user commands to {@link CanteenFinderParser} and the finding of the
     * nearest canteen to {@link CanteenFinder}. If any errors occur during parsing or
     * searching, appropriate error messages are displayed to guide the user.
     * <p>
     * When a valid command is processed, the method retrieves the nearest canteen data and
     * displays it to the user using {@link CanteenFinderTextUi#printNearestCanteenCF(NearestCanteenData)}.
     * If the user chooses to exit, a farewell message is displayed before terminating the loop.
     *
     * @see CanteenFinderParser#parseCanteenFinderCommand(String)
     * @see CanteenFinder#findNearestCanteen(UserFields)
     * @see CanteenFinderTextUi#printNearestCanteenCF(NearestCanteenData)
     */
    public static void startCanteenFinder() {
        CanteenFinderTextUi.printCanteenFinderGreetingCF();
        String command;
        while (true) {
            command = NaviTextUi.IN.nextLine().trim();

            if (command.equalsIgnoreCase("e") ||
                    command.equalsIgnoreCase("exit")) {
                CanteenFinderTextUi.printExitCanteenFinderCF();
                break;
            }

            UserFields userFields;
            try {
                userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            } catch (InvalidSearchType e) {
                CanteenFinderTextUi.printInvalidSearchTypeCF();
                continue;
            } catch (EmptyCanteenFinderCommand e) {
                CanteenFinderTextUi.printEmptyCanteenFinderCommandCF();
                continue;
            } catch (MissingCanteenFinderFields e) {
                CanteenFinderTextUi.printMissingCanteenFinderFieldsCF();
                continue;
            } catch (InvalidCanteenCriteria e) {
                CanteenFinderTextUi.printInvalidCanteenCriteriaCF();
                continue;
            } catch (NILWithOtherCriteria e) {
                CanteenFinderTextUi.printNILWithOtherCriteriaErrorCF();
                continue;
            } catch (DuplicateCanteenCriterion e) {
                CanteenFinderTextUi.printDuplicateCanteenCriteriaCF();
                continue;
            } catch (HCAndMOCriteriaError e) {
                CanteenFinderTextUi.printHCAndMOCriteriaErrorCF();
                continue;
            }

            assert userFields != null : "userFields should never be null";

            try {
                NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(userFields);
                CanteenFinderTextUi.printNearestCanteenCF(nearestCanteenData);
            } catch (LocationNotFound e) {
                CanteenFinderTextUi.printLocationNotFoundCF();
            } catch (CanteenNotFound e) {
                CanteenFinderTextUi.printCanteenNotFoundCF();
            }
        }
    }
}

