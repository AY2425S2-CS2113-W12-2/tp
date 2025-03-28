package seedu.navi.textui;

import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;

import java.util.ArrayList;
import java.util.Scanner;


public class TextUi {
    private static final String LOGO = """
                
                 _   _             _
                | \\ | | __ ___   _(_)
                |  \\| |/ _` \\ \\ / / |
                | |\\  | (_| |\\ V /| |
                |_| \\_|\\__,_| \\_/ |_|""";

    public static final Scanner IN = new Scanner(System.in);

    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * @author kevinchangckc
     */
    public static void printGreeting() {
        printLineSeparator();
        System.out.println("G'day mate! I'm:" + LOGO);
        System.out.println("What’s your name, legend?");
        printLineSeparator();
    }

    /**
     * @author kevinchangckc
     */
    public static void printGreetUser(String name) {
        printLineSeparator();
        System.out.println("Aye, " + name + "! Stoked to have ya here!");
        System.out.println("Alrighty, what can I do for ya?");
        printLineSeparator();
    }

    public static void printCanteenFinderGreetingCF() {
        printLineSeparator();
        System.out.println("So you wanna find where's the nearest canteen to you?");
        System.out.println("What kind of canteen are you looking for?");
        System.out.println("""
                You can list out: "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printEmptyCanteenCriteriaCF() {
        printLineSeparator();
        System.out.println("Oh no! You did not enter anything!");
        System.out.println("""
                "Please enter either: "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printWhereIsUserCF() {
        printLineSeparator();
        System.out.println("Alright! Now I know what kind of Canteen you're looking for,");
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
        System.out.println("Alright! The nearest canteen to you that fit your criteria is");
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
        System.out.println("Sorry! I couldn't find any canteen that meets your criteria. :(");
        System.out.println("Please try another set of criteria!");
        printRepeatCanteenFinderCF();
        printLineSeparator();
    }

    public static void printInvalidCanteenCriteriaCF() {
        printLineSeparator();
        System.out.println("Please enter a valid criteria that is,");
        System.out.println("""
                "Halal Certified, Muslim Owned, Vegetarian, Aircon"
                or "NIL" if you're fine with anything!""");
        printLineSeparator();
    }

    public static void printNILWithOtherCriteriaErrorCF() {
        printLineSeparator();
        System.out.println("You can't include other criteria with \"NIL\"!");
        printLineSeparator();
    }

    public static void printDuplicateCanteenCriteriaCF() {
        printLineSeparator();
        System.out.println("You've entered the same type of criteria more than once!");
        printLineSeparator();
    }

    public static void printHCAndMOCriteriaErrorCF() {
        printLineSeparator();
        System.out.println("Please enter either Halal Certified or Muslim Owned and not both!");
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
}
