package seedu.navi.favorites;

import seedu.navi.textui.TextUi;

import java.util.Scanner;

public class FavoritesParser {
    private static Favorites favorites;
    private static Scanner scanner;

    public FavoritesParser(Favorites favorites) {
        FavoritesParser.favorites = favorites;
    }

    public static void start() {
        scanner = new Scanner(System.in);
        TextUi.printLineSeparator();
        System.out.println("🌟 Favorites Tracker: Enter a command:");
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
                System.out.println("⚠️ Please enter a command.");
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
                break;
            case "undo":
                favorites.undoRemove();
                break;
            case "exit":
                TextUi.printLineSeparator();
                System.out.println("👋 Exiting Favorites Tracker.");
                TextUi.printLineSeparator();
                return;
            default:
                TextUi.printLineSeparator();
                System.out.println("⚠️ Unknown command. Try: add description : rating : location, remove N, view, " +
                        "sort asc/desc, search X, " + "undo, exit.");
                TextUi.printLineSeparator();
            }
        }
    }

    private static void handleAddCommand(String arguments) {
        // Split the input using a regular expression that allows optional spaces around the colon
        String[] params = arguments.split("\\s*:\\s*");

        // Ensure there are exactly 3 parts after splitting
        if (params.length != 3) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ Invalid format. Use: add <description> : <rating> : <location>");
            TextUi.printLineSeparator();
            return;
        }

        try {
            TextUi.printLineSeparator();

            // Trim any leading/trailing spaces from description and category
            String description = params[0].trim();
            int rating = Integer.parseInt(params[1].trim());
            String category = params[2].trim();

            // Add to favorites list
            favorites.addFavorite(description, rating, category);

            TextUi.printLineSeparator();
        } catch (NumberFormatException e) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ Rating must be a number.");
            TextUi.printLineSeparator();
        }
    }



    private static void handleRemoveCommand(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim()) - 1; // Convert to 0-based index
            favorites.removeFavorite(index);
        } catch (NumberFormatException e) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ Please enter a valid index number.");
            TextUi.printLineSeparator();
        }
    }

    private static void handleSortCommand(String arguments) {
        if (arguments.equalsIgnoreCase("asc")) {
            favorites.sortFavorites(false);
        } else if (arguments.equalsIgnoreCase("desc")) {
            favorites.sortFavorites(true);
        } else {
            System.out.println("⚠️ Invalid sort command. Use: sort asc OR sort desc");
        }
    }
}
