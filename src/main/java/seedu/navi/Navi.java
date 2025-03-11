package seedu.navi;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = "\n" +
                " _   _             _ \n" +
                "| \\ | | __ ___   _(_)\n" +
                "|  \\| |/ _` \\ \\ / / |\n" +
                "| |\\  | (_| |\\ V /| |\n" +
                "|_| \\_|\\__,_| \\_/ |_|";
        System.out.println("Good day! I am: " + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Aye " + in.nextLine() + "!");
    }
}
