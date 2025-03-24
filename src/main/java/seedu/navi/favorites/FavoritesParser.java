package seedu.navi.favorites;

import java.util.Scanner;

public class FavoritesParser {
    private static Favorites favorites;
    private static Scanner scanner;

    public FavoritesParser(Favorites favorites) {
        FavoritesParser.favorites = favorites;
    }

    public static void start() {
        scanner = new Scanner(System.in);
        System.out.println("🌟 Favorites Tracker: Enter a command (add X : Y : Z, remove N, view, sort asc/desc, search X, undo, exit)");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("⚠️ Please enter a command.");
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
                System.out.println("👋 Exiting Favorites Tracker.");
                return;
            default:
                System.out.println("⚠️ Unknown command. Try: add X : Y : Z, remove N, view, sort asc/desc, search X, undo, exit.");
            }
        }
    }

    private static void handleAddCommand(String arguments) {
        String[] params = arguments.split(" : ");
        if (params.length != 3) {
            System.out.println("⚠️ Invalid format. Use: add <description> : <rating> : <category>");
            return;
        }

        try {
            String description = params[0].trim();
            int rating = Integer.parseInt(params[1].trim());
            String category = params[2].trim();
            favorites.addFavorite(description, rating, category);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Rating must be a number.");
        }
    }

    private static void handleRemoveCommand(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim()) - 1; // Convert to 0-based index
            favorites.removeFavorite(index);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Please enter a valid index number.");
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
