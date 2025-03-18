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
        System.out.println("🌟 Favorites Tracker: Enter a command (add X, remove X, view, exit)");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("⚠️ Please enter a command.");
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String item = "";

            if (parts.length > 1) {
                item = parts[1].trim();
            }

            switch (command) {
            case "add":
                favorites.addFavorite(item);
                break;
            case "remove":
                favorites.removeFavorite(item);
                break;
            case "view":
                favorites.viewFavorites();
                break;
            case "exit":
                System.out.println("👋 Exiting Favorites Tracker.");
                return;
            default:
                System.out.println("⚠️ Unknown command. Try: add X, remove X, view, exit.");
            }
        }
    }
}
