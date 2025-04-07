package seedu.navi.textui;

import static seedu.navi.textui.TextUi.printLineSeparator;

public class CanteenMainTextUi {
    public static void printCanteenGreetingC() {
        printLineSeparator();
        System.out.println("You've entered the Canteen feature!");
        System.out.println("You can enter \"finder\" to look for the nearest canteen to you,");
        System.out.println("or you can enter \"lookup\" to see a canteen's stalls information.");
        printLineSeparator();
    }

    public static void printExitCanteenC() {
        printLineSeparator();
        System.out.println("You've exited the Canteen feature!");
        printLineSeparator();
    }

    public static void printInvalidCommandC() {
        printLineSeparator();
        System.out.println("You've entered an invalid command!");
        System.out.println("Please only enter \"finder\", \"lookup\" or \"exit\".");
        printLineSeparator();
    }
}
