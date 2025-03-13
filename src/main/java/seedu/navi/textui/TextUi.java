package seedu.navi.textui;

import seedu.navi.canteenfinder.landmark.canteen.Canteen;

public class TextUi {
    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printNearestCanteen(Canteen nearestCanteen) {
        printLineSeparator();
        System.out.println("The nearest canteen to you is " + nearestCanteen.getName());
        printLineSeparator();
    }
}
