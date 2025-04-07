package seedu.navi.textui;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;

import java.util.ArrayList;

import static seedu.navi.textui.NaviTextUi.printLineSeparator;

/**
 * The CanteenFinderTextUi class provides methods to handle text-based user interaction specifically
 * for the Canteen Finder feature. It displays messages, prompts, and errors to guide users through
 * the process of finding the nearest canteen based on their criteria.
 */
public class CanteenFinderTextUi {

    /**
     * Prints the greeting message for the Canteen Finder feature.
     * <p>
     * This method explains the format of the command required to use the Canteen Finder feature.
     */
    public static void printCanteenFinderGreetingCF() {
        printLineSeparator();
        System.out.print("""
                So you wanna find where's the nearest canteen to you?
                You can enter the command as follows:
                "search type | your location | canteen criterion 1, canteen criterion 2"
                """);
        printLineSeparator();
    }

    /**
     * Prints an error message when the user does not enter any command in the Canteen Finder feature.
     * <p>
     * This method reminds the user of the correct command format.
     */
    public static void printEmptyCanteenFinderCommandCF() {
        printLineSeparator();
        System.out.print("""
                Oh no! You did not enter anything!
                Please enter the command as follows:
                "search type | your location | canteen criterion 1, canteen criterion 2"
                """);
        printLineSeparator();
    }

    /**
     * Prints an error message when the user misses required fields in the Canteen Finder feature.
     * <p>
     * This method reminds the user of the correct command format.
     */
    public static void printMissingCanteenFinderFieldsCF() {
        printLineSeparator();
        System.out.print("""
                Oh no! You did not fill in all the required fields!
                Please enter the command as follows:
                "search type | your location | canteen criterion 1, canteen criterion 2"
                """);
        printLineSeparator();
    }

    /**
     * Prints an error message when the user enters an invalid search type in the Canteen Finder feature.
     * <p>
     * This method explains the valid search types and prompts the user to correct their input.
     */
    public static void printInvalidSearchTypeCF() {
        printLineSeparator();
        System.out.println("Oh no! You did not enter a valid search type!");
        System.out.println("Please enter either 1 (match any criteria) or 2 (match all criteria).");
        printLineSeparator();
    }

    /**
     * Prints the details of the nearest canteen that matches the user's criteria.
     * <p>
     * This method displays the canteen's name, valid stalls, and distance from the user's location.
     *
     * @param nearestCanteenData An object containing the nearest canteen's data, including its name, distance,
     *                           and valid stalls.
     */
    public static void printNearestCanteenCF(NearestCanteenData nearestCanteenData) {
        printLineSeparator();
        System.out.println("Alright! The nearest canteen to you that fit your criteria is");
        System.out.println(nearestCanteenData.nearestCanteen().getName());
        System.out.println("which is: ");
        printValidStallsCF(nearestCanteenData.validStalls());
        System.out.println("and it is approximately at most " + nearestCanteenData.canteenDistance()
                + "m from where you are.");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    /**
     * Prints an error message when the user's location is not found in the system.
     * <p>
     * This method informs the user that their location is invalid and prompts them to try again.
     */
    public static void printLocationNotFoundCF() {
        printLineSeparator();
        System.out.println("Sorry! The location you entered does not exist in my data. :(");
        System.out.println("Please try another location!");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    /**
     * Prints an error message when no canteen matches the user's criteria.
     * <p>
     * This method informs the user that no matching canteen was found and prompts them to adjust their criteria.
     */
    public static void printCanteenNotFoundCF() {
        printLineSeparator();
        System.out.println("Sorry! I couldn't find any canteen that meets your criteria. :(");
        System.out.println("Please try another set of criteria!");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    /**
     * Prints an error message when the user enters invalid canteen criteria.
     * <p>
     * This method lists the valid criteria and prompts the user to correct their input.
     */
    public static void printInvalidCanteenCriteriaCF() {
        printLineSeparator();
        System.out.println("Please enter a valid criteria that is,");
        System.out.println("""
                "Halal Certified", "Muslim Owned", "Vegetarian", "Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user includes "NIL" with other criteria.
     * <p>
     * This method informs the user that "NIL" cannot be combined with other criteria.
     */
    public static void printNILWithOtherCriteriaErrorCF() {
        printLineSeparator();
        System.out.println("You can't include other criteria with \"NIL\"!");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user enters duplicate criteria.
     * <p>
     * This method informs the user that duplicate criteria are not allowed.
     */
    public static void printDuplicateCanteenCriteriaCF() {
        printLineSeparator();
        System.out.println("You've entered the same type of criteria more than once!");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user includes both "Halal Certified" and "Muslim Owned" criteria.
     * <p>
     * This method informs the user to choose only one of these criteria.
     */
    public static void printHCAndMOCriteriaErrorCF() {
        printLineSeparator();
        System.out.println("Please enter either Halal Certified or Muslim Owned and not both");
        System.out.println("for search type 2!");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user includes both "Halal Certified" and "Muslim Owned" criteria.
     * <p>
     * This method informs the user to choose only one of these criteria.
     */
    public static void printExitCanteenFinderCF() {
        printLineSeparator();
        System.out.println("You have exited the Canteen Finder feature!");
        printLineSeparator();
    }

    private static void printRepeatCanteenFinderCF() {
        System.out.println("You can enter your canteen criteria again to start the search again,");
        System.out.println("or \"exit\" to exit canteen finder.");
    }

    /**
     * Prints the list of valid stalls in a canteen.
     * <p>
     * This method iterates through the list of stalls and prints their details.
     *
     * @param validStalls A list of {@link Stall} objects representing the valid stalls to display.
     */
    public static void printValidStallsCF(ArrayList<Stall> validStalls) {
        for (Stall stall : validStalls) {
            System.out.print(stall);
        }
    }
}
