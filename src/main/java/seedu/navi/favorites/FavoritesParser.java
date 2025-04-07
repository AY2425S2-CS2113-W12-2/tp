package seedu.navi.favorites;

import seedu.navi.textui.TextUi;

import java.util.Scanner;

public class FavoritesParser {
    private static Favorites favorites;
    private Scanner scanner;

    public FavoritesParser(Favorites favorites) {
        this.favorites = favorites;
    }

    public void start() {
        scanner = new Scanner(System.in);
        TextUi.printLineSeparator();
        System.out.println("Favorites Tracker: Enter a command:");
        System.out.println("  - add <description> : <rating> : <location>");
        System.out.println("  - remove N");
        System.out.println("  - view");
        System.out.println("  - sort asc");
        System.out.println("  - sort desc");
        System.out.println("  - search X");
        System.out.println("  - undo");
        System.out.println("  - exit");
        TextUi.printLineSeparator();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                TextUi.printLineSeparator();
                System.out.println("Please enter a command.");
                TextUi.printLineSeparator();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String arguments = (parts.length > 1) ? parts[1].trim() : "";

            switch (command) {
            case "add":
                handleAddCommand(arguments);
                break;
            case "remove":
                handleRemoveCommand(arguments);
                break;
            case "view":
                favorites.viewFavorites();
                break;
            case "sort":
                handleSortCommand(arguments);
                break;
            case "search":
                favorites.searchFavorites(arguments);
                TextUi.printLineSeparator();
                break;
            case "undo":
                favorites.undoRemove();
                break;
            case "exit":
                TextUi.printLineSeparator();
                System.out.println("Exiting Favorites Tracker.");
                TextUi.printLineSeparator();
                return;
            default:
                TextUi.printLineSeparator();
                System.out.println("Unknown command. Try: add description : rating : location, remove N, view, " +
                        "sort asc/desc, search X, undo, exit.");
                TextUi.printLineSeparator();
            }
        }
    }

    private static void handleAddCommand(String arguments) {
        // Use regular expression to split by ":" while allowing spaces/tabs before/after
        String[] params = arguments.split("\\s*:\\s*");

        // Check if there are exactly 3 parameters
        if (params.length != 3) {
            TextUi.printLineSeparator();
            System.out.println("Invalid format. Use: add <description> : <rating> : <location>");
            TextUi.printLineSeparator();
            return;
        }

        try {
            TextUi.printLineSeparator();

            // Trim each part to remove any surrounding spaces/tabs
            String description = params[0].trim();
            int rating = Integer.parseInt(params[1].trim());  // Parse rating to an integer

            // Check if the rating is less than 100
            if (rating >= 100) {

                System.out.println("Rating must be a number less than 100.");
                TextUi.printLineSeparator();
                return;
            }

            String category = params[2].trim();

            // Add to favorites
            favorites.addFavorite(description, rating, category);

            TextUi.printLineSeparator();
        } catch (NumberFormatException e) {

            System.out.println("Rating must be a valid number less than 100.");
            TextUi.printLineSeparator();
        }
    }



    private void handleRemoveCommand(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim()) - 1;
            favorites.removeFavorite(index);
        } catch (NumberFormatException e) {
            TextUi.printLineSeparator();
            System.out.println("Please enter a valid index number.");
            TextUi.printLineSeparator();
        }
    }

    private void handleSortCommand(String arguments) {
        if (arguments.equalsIgnoreCase("asc")) {
            favorites.sortFavorites(false);
        } else if (arguments.equalsIgnoreCase("desc")) {
            favorites.sortFavorites(true);
        } else {
            System.out.println("Invalid sort command. Use: sort asc OR sort desc");
        }
    }
}
