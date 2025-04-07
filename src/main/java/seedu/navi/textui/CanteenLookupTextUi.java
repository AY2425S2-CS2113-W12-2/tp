package seedu.navi.textui;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

import static seedu.navi.textui.NaviTextUi.printLineSeparator;

/**
 * The CanteenLookupTextUi class provides methods to handle text-based user interaction specifically
 * for the Canteen Lookup feature. It displays messages, prompts, and errors to guide users through
 * the process of looking up canteen stall information.
 */
public class CanteenLookupTextUi {

    /**
     * Prints the greeting message for the Canteen Lookup feature.
     * <p>
     * This method explains how to use the Canteen Lookup feature, including an example of a valid canteen name.
     */
    public static void printCanteenLookupGreetingCL() {
        printLineSeparator();
        System.out.println("You've entered the Canteen Lookup feature!");
        System.out.println("Enter any Canteen in NUS to check what kind of stalls it have!");
        System.out.println("Eg. Techno Edge");
        printLineSeparator();
    }

    /**
     * Prints a message when the user exits the Canteen Lookup feature.
     * <p>
     * This method confirms that the user has exited the feature.
     */
    public static void printExitCanteenLookupCL() {
        printLineSeparator();
        System.out.println("You've exited the Canteen Lookup feature");
        printLineSeparator();
    }

    /**
     * Prints the list of stalls in a specific canteen.
     * <p>
     * This method displays the canteen's name and iterates through the list of stalls to print their details.
     *
     * @param canteenName The name of the canteen.
     * @param stalls A list of {@link Stall} objects representing the stalls in the canteen.
     */
    public static void printCanteenStallsCL(String canteenName, ArrayList<Stall> stalls) {
        printLineSeparator();
        System.out.println("Here are all the stalls in " + canteenName + ":");
        CanteenFinderTextUi.printValidStallsCF(stalls);
        printLineSeparator();
    }

    /**
     * Prints an error message when the requested canteen is not found.
     * <p>
     * This method informs the user that the requested canteen could not be found.
     */
    public static void printCanteenNotFoundCL() {
        printLineSeparator();
        System.out.println("Sorry, we could not find the canteen you're looking for!");
        printLineSeparator();
    }
}
