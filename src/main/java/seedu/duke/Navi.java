package seedu.duke;

import java.util.Scanner;

public class Navi {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = "Navi";
        System.out.println("Hello from: " + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
