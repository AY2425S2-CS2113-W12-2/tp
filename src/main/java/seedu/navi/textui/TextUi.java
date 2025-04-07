package seedu.navi.textui;

import java.util.Scanner;


public class TextUi {
    public static final Scanner IN = new Scanner(System.in);

    private static final String LOGO = """
                
                 _   _             _
                | \\ | | __ ___   _(_)
                |  \\| |/ _` \\ \\ / / |
                | |\\  | (_| |\\ V /| |
                |_| \\_|\\__,_| \\_/ |_|""";

    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * @author kevinchangckc
     */
    public static void printGreeting() {
        printLineSeparator();
        System.out.println("Welcome! I'm:" + LOGO);
        System.out.println("Alright, what can I do for you?");
        printLineSeparator();
    }

    /**
     * @author kevinchangckc
     */
    public static void printExitMessage() {
        printLineSeparator();
        System.out.println("Ah, you’re heading off? No worries!");
        System.out.println("We’ll catch you next time!");
        printLineSeparator();
    }

    public static void printInvalidCommand() {
        printLineSeparator();
        System.out.print("""
                You've entered an invalid command!
                Remember that I can help you with:
                - "canteen" to find canteens
                - "budget" to set or check your budget
                - "favorites" to manage your favorite spots
                - "exit" to quit Navi
                """);
        printLineSeparator();
    }
}
