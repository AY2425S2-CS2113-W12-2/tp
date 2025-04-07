package seedu.navi.textui;

import java.util.Scanner;

/**
 * The NaviTextUi class provides methods to handle user interaction through text-based input and output.
 * It displays messages, prompts, and errors to guide users and present information in a structured format
 * for the Navi main menu.
 */
public class NaviTextUi {

    /**
     * A static {@link Scanner} object used to read user input from the console.
     */
    public static final Scanner IN = new Scanner(System.in);

    private static final String LOGO = """
                
                 _   _             _
                | \\ | | __ ___   _(_)
                |  \\| |/ _` \\ \\ / / |
                | |\\  | (_| |\\ V /| |
                |_| \\_|\\__,_| \\_/ |_|""";

    /**
     * Prints a line separator to visually separate sections of the console output.
     */
    public static void printLineSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Prints the greeting message when the application starts.
     * <p>
     * This method displays the application logo and a welcome message to introduce the user to the system.
     * @author kevinchangckc
     */
    public static void printGreeting() {
        printLineSeparator();
        System.out.println("Welcome! I'm:" + LOGO);
        System.out.println("Alright, what can I do for you?");
        printLineSeparator();
    }

    /**
     * Prints the exit message when the user chooses to quit the application.
     * <p>
     * This method displays a farewell message to thank the user and signal the end of the session.
     * @author kevinchangckc
     */
    public static void printExitMessage() {
        printLineSeparator();
        System.out.println("Ah, you’re heading off? No worries!");
        System.out.println("We’ll catch you next time!");
        printLineSeparator();
    }

    /**
     * Prints an error message when the user enters an invalid command.
     * <p>
     * This method lists valid commands and guides the user on how to proceed.
     */
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
