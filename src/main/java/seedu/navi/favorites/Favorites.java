package seedu.navi.favorites;

import seedu.navi.textui.TextUi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Favorites {
    private static final String FILE_PATH = "favorites.txt"; // Path to save the favorites data
    private List<String> favoriteItems;
    private Stack<String> undoStack;


    public Favorites() {
        this.favoriteItems = new ArrayList<>();
        this.undoStack = new Stack<>();
    }

    // Loads the favorites from the file into the favoriteItems list
    private void loadFavorites() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                favoriteItems.add(line);
            }
        } catch (IOException e) {
            // If file doesn't exist or can't be read, we initialize with an empty list
        }
    }

    // Saves the current favoriteItems list to a file
    private void saveFavorites() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String item : favoriteItems) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving favorites to file.");
        }
    }
    public void clearFavorites() {
        favoriteItems.clear();
        undoStack.clear();
        saveFavorites();
    }


    public void addFavorite(String description, int rating, String category) {
        String item = description + " | Rating: " + rating + " | Category: " + category;
        favoriteItems.add(item);
        saveFavorites();
        System.out.println("✅ Added: " + item);
    }

    public void removeFavorite(int index) {
        if (index < 0 || index >= favoriteItems.size()) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ Invalid index.");
            TextUi.printLineSeparator();
            return;
        }
        String removedItem = favoriteItems.remove(index);
        undoStack.push(removedItem);
        saveFavorites();
        TextUi.printLineSeparator();
        System.out.println("❌ Removed: " + removedItem);
        TextUi.printLineSeparator();
    }

    public void undoRemove() {
        if (undoStack.isEmpty()) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ No recent deletions to undo.");
            TextUi.printLineSeparator();
            return;
        }
        String restoredItem = undoStack.pop();
        favoriteItems.add(restoredItem); // <-- This just adds it at the end, not its original position
        TextUi.printLineSeparator();
        System.out.println("🔄 Restored: " + restoredItem);
        TextUi.printLineSeparator();
    }


    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
    }

    public void viewFavorites() {
        // Load the favorites when viewing them, if the list is empty
        if (favoriteItems.isEmpty()) {
            loadFavorites(); // Only load favorites if the list is empty
        }
        if (favoriteItems.isEmpty()) {
            TextUi.printLineSeparator();
            System.out.println("No favorites yet.");
            TextUi.printLineSeparator();
        } else {
            TextUi.printLineSeparator();
            System.out.println("🌟 Your favorite items:");
            for (int i = 0; i < favoriteItems.size(); i++) {
                System.out.println((i + 1) + ". " + favoriteItems.get(i));
            }
            TextUi.printLineSeparator();
        }
    }

    public void sortFavorites(boolean descending) {
        favoriteItems.sort((a, b) -> {
            int ratingA = Integer.parseInt(a.split("\\| Rating: ")[1].split(" ")[0]);
            int ratingB = Integer.parseInt(b.split("\\| Rating: ")[1].split(" ")[0]);
            return descending ? Integer.compare(ratingB, ratingA) : Integer.compare(ratingA, ratingB);
        });
        saveFavorites();
        TextUi.printLineSeparator();
        System.out.println("📊 Favorites sorted in " + (descending ? "descending" : "ascending") + " order.");
        TextUi.printLineSeparator();
    }

    public boolean searchFavorites(String keyword) {
        TextUi.printLineSeparator();
        System.out.println("🔎 Search results for '" + keyword + "':");
        TextUi.printLineSeparator();
        boolean found = false;
        for (String item : favoriteItems) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No matching favorites found.");
        }
        return found;

    }
}

