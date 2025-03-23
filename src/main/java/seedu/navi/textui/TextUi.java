package seedu.navi.textui;

import seedu.navi.canteenfinder.NearestCanteenData;

import java.util.ArrayList;

public class TextUi {
    private static final String logo = """
                
                 _   _             _
                | \\ | | __ ___   _(_)
                |  \\| |/ _` \\ \\ / / |
                | |\\  | (_| |\\ V /| |
                |_| \\_|\\__,_| \\_/ |_|""";

    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printGreeting() {
        printLineSeparator();
        System.out.println("G'day mate! I'm:" + logo);
        System.out.println("What’s your name, legend?");
        printLineSeparator();
    }

    public static void printGreetUser(String name) {
        printLineSeparator();
        System.out.println("Aye, " + name + "! Stoked to have ya here!");
        System.out.println("Alrighty, what can I do for ya?");
        printLineSeparator();
    }

    public static void printEnterFunctionCF() {
        printLineSeparator();
        System.out.println("So you wanna find where's the nearest canteen to ya?");
        System.out.println("What kind of canteen you're looking for?");
        System.out.println("""
                You can list out: "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printEmptyDietRestrictionCF() {
        printLineSeparator();
        System.out.println("Oh no! You did not enter anything!");
        System.out.println("""
                "Please enter either: "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printWhereIsUserCF() {
        printLineSeparator();
        System.out.println("Alrighty! Now I know what kind of Canteen you're looking for,");
        System.out.println("I would need to know where are you now!");
        System.out.println("You can enter either faculties, hostels or other major landmarks in NUS!");
        printLineSeparator();
    }

    public static void printEmptyLandmarkCF() {
        printLineSeparator();
        System.out.println("Oh no! You did not enter anything!");
        System.out.println("Please enter either faculties, hostels or other major landmarks in NUS!");
        printLineSeparator();
    }

    public static void printNearestCanteenCF(NearestCanteenData nearestCanteenData) {
        printLineSeparator();
        System.out.println("Alrighty! The nearest canteen to you that fit your criteria is");
        System.out.println(nearestCanteenData.nearestCanteen().getName());
        System.out.println("which has: ");
        printValidStallsCF(nearestCanteenData.validStalls());
        System.out.println("and it is approximately at most " + nearestCanteenData.landmarkToCanteenDist()
                + "m from where you are.");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    public static void printLocationNotFoundCF() {
        printLineSeparator();
        System.out.println("Sorry! The location you entered does not exist in my data. :(");
        System.out.println("Please try another location!");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    public static void printCanteenNotFoundCF() {
        printLineSeparator();
        System.out.println("Sorry! I couldn't find any canteen that meets you're criteria. :(");
        System.out.println("Please try another set of criteria!");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    public static void printInvalidDietRestrictionsCF() {
        printLineSeparator();
        System.out.println("Please enter a valid criteria that is,");
        System.out.println("""
                "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printNILWithOtherRestrictionsErrorCF() {
        printLineSeparator();
        System.out.println("You can't include other criteria with \"NIL\"!");
        printLineSeparator();
    }

    public static void printExitCanteenFinderCF() {
        printLineSeparator();
        System.out.println("You have exited the Canteen Finder feature!");
        printLineSeparator();
    }

    private static void printRepeatCanteenFinderCF() {
        System.out.println("You can enter your canteen criteria again to start the search again,");
        System.out.println("or \"exit\" to exit canteen finder.");
    }

    private static void printValidStallsCF(ArrayList<String> validStalls) {
        for (String stall : validStalls) {
            System.out.println(stall);
        }
    }
}

