package seedu.navi.textui;

import seedu.navi.canteenfinder.landmark.canteen.Canteen;

public class TextUi {
    private static final String logo = """
                
                 _   _             _
                | \\ | | __ ___   _(_)
                |  \\| |/ _` \\ \\ / / |
                | |\\  | (_| |\\ V /| |
                |_| \\_|\\__,_| \\_/ |_|""";

    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printNearestCanteen(Canteen nearestCanteen) {
        printLineSeparator();
        System.out.println("The nearest canteen to you is " + nearestCanteen.getName());
        printLineSeparator();
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
}
