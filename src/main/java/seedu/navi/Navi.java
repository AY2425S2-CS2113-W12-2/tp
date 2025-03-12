package seedu.navi;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = "\n" +
                " _   _             _\n" +
                "| \\ | | __ ___   _(_)\n" +
                "|  \\| |/ _` \\ \\ / / |\n" +
                "| |\\  | (_| |\\ V /| |\n" +
                "|_| \\_|\\__,_| \\_/ |_|";
        System.out.println("G'day mate! I'm:" + logo);
        System.out.println("What’s your name, legend?");

        Scanner in = new Scanner(System.in);
        System.out.println("Aye, " + in.nextLine() + "! Stoked to have ya here!");

        // Start command processing
        Navi ui = new Navi();
        Parser parser = new Parser(ui);

        System.out.println("Alrighty, what can I do for ya?");
        while (true) {
            String input = in.nextLine();
            parser.handleCommand(input);
        }
    }

    public void showExitMessage() {
        System.out.println("_________________________________________");
        System.out.println("Ahh, you’re headin’ off? No worries!");
        System.out.println("Keep on keepin’ on, and we’ll catch ya next time!");
        System.out.println("_________________________________________");
    }

    public void showError(String message) {
        System.out.println("⚠ Whoops! " + message);
        System.out.println("That one’s a bit crook, but no dramas – give it another go!");
    }
}

/**
 * Custom exception class for chatbot errors.
 */
class NaviException extends Exception {
    public NaviException(String message) {
        super("⚠ Oi! " + message + " Let's get this sorted, mate.");
    }
}

class Parser {
    private final Navi ui;

    public Parser(Navi ui) {
        this.ui = ui;
    }

    public void handleCommand(String input) {
        try {
            if (input.equalsIgnoreCase("bye")) {
                ui.showExitMessage(); // Use instance method via object
                System.exit(0);
            } else {
                throw new NaviException("That’s not quite right, mate. Give it another shot!");
            }
        } catch (NaviException e) {
            ui.showError(e.getMessage());
        }
    }
}
