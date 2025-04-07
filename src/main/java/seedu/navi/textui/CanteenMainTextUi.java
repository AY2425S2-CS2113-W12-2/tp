package seedu.navi.textui;

import static seedu.navi.textui.NaviTextUi.printLineSeparator;

/**
 * The CanteenMainTextUi class provides methods to handle text-based user interaction specifically
 * for the Canteen feature. It displays messages, prompts, and errors to guide users through the
 * available options within the Canteen feature.
 */
public class CanteenMainTextUi {

    /**
     * Prints the greeting message for the Canteen feature.
     * <p>
     * This method explains the available options within the Canteen feature, such as using the
     * "finder" command to locate the nearest canteen or the "lookup" command to view stall information.
     */
    public static void printCanteenGreetingC() {
        printLineSeparator();
        System.out.println("You've entered the Canteen feature!");
        System.out.println("You can enter \"finder\" to look for the nearest canteen to you,");
        System.out.println("or you can enter \"lookup\" to see a canteen's stalls information.");
        printLineSeparator();
    }

    /**
     * Prints a message when the user exits the Canteen feature.
     * <p>
     * This method confirms that the user has exited the Canteen feature.
     */
    public static void printExitCanteenC() {
        printLineSeparator();
        System.out.println("You've exited the Canteen feature!");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user enters an invalid command in the Canteen feature.
     * <p>
     * This method lists the valid commands ("finder", "lookup", "exit") and prompts the user to
     * correct their input.
     */
    public static void printInvalidCommandC() {
        printLineSeparator();
        System.out.println("You've entered an invalid command!");
        System.out.println("Please only enter \"finder\", \"lookup\" or \"exit\".");
        printLineSeparator();
    }
}
