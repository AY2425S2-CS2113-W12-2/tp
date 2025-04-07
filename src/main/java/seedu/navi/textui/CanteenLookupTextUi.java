package seedu.navi.textui;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

import static seedu.navi.textui.TextUi.printLineSeparator;

public class CanteenLookupTextUi {
    public static void printCanteenLookupGreetingCL() {
        printLineSeparator();
        System.out.println("You've entered the Canteen Lookup feature!");
        System.out.println("Enter any Canteen in NUS to check what kind of stalls it have!");
        System.out.println("Eg. Techno Edge");
        printLineSeparator();
    }

    public static void printExitCanteenLookupCL() {
        printLineSeparator();
        System.out.println("You've exited the Canteen Lookup feature");
        printLineSeparator();
    }

    public static void printCanteenStallsCL(String canteenName, ArrayList<Stall> stalls) {
        printLineSeparator();
        System.out.println("Here are all the stalls in " + canteenName + ":");
        CanteenFinderTextUi.printValidStallsCF(stalls);
        printLineSeparator();
    }

    public static void printCanteenNotFoundCL() {
        printLineSeparator();
        System.out.println("Sorry, we could not find the canteen you're looking for!");
        printLineSeparator();
    }
}
