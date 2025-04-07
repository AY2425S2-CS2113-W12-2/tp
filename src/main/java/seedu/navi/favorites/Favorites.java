package seedu.navi.favorites;

import javafx.util.Pair;
import seedu.navi.textui.NaviTextUi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Manages the user's list of favorite items.
 * Provides functionality for adding, removing, viewing, sorting, searching, and undoing deletions of favorites.
 * Handles persistent storage by saving and loading favorites from a file.
 */
public class Favorites {
    private static final String FILE_PATH = "favorites.txt"; // Path to save the favorites data
    private List<String> favoriteItems;
    private Stack<Pair<Integer, String>> undoStack;  // Stores (index, item)

    /**
     * Constructs a Favorites object with an empty favorites list and undo stack.
     */
    public Favorites() {
        this.favoriteItems = new ArrayList<>();
        this.undoStack = new Stack<>();
        assert favoriteItems != null : "favoriteItems list should not be null";
        assert undoStack != null : "undoStack should not be null";
    }

    /**
     * Loads the favorites from the save file into the favorites list.
     * If the file does not exist, initializes with an empty list.
     */
    private void loadFavorites() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                favoriteItems.add(line);
            }
        } catch (IOException e) {
            // Initialize with empty list if file not found or unreadable
        }
    }

    /**
     * Saves the current favorites list to the save file.
     */
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

    /**
     * Clears all favorites and the undo stack.
     * Saves the cleared state to file.
     */
    public void clearFavorites() {
        favoriteItems.clear();
        undoStack.clear();
        saveFavorites();
    }

    /**
     * Adds a new favorite item with the given details.
     *
     * @param description The description of the item.
     * @param rating The rating of the item.
     * @param category The category of the item.
     */
    public void addFavorite(String description, int rating, String category) {
        String item = description + " | Rating: " + rating + " | Location: " + category;
        favoriteItems.add(item);
        saveFavorites();
        System.out.println("Added: " + item);
    }

    /**
     * Removes the favorite item at the specified index.
     * Stores the removed item in the undo stack for possible restoration.
     *
     * @param index The index of the item to remove (0-based).
     */
    public void removeFavorite(int index) {
        
        if (index < 0 || index >= favoriteItems.size()) {
            NaviTextUi.printLineSeparator();
            System.out.println("Invalid index.");
            NaviTextUi.printLineSeparator();
            return;
        }
        String removedItem = favoriteItems.remove(index);
        undoStack.push(new Pair<>(index, removedItem));
        saveFavorites();
        NaviTextUi.printLineSeparator();
        System.out.println("Removed: " + removedItem);
        NaviTextUi.printLineSeparator();
    }

    /**
     * Undoes the most recent removal of a favorite item.
     * Restores the removed item to its original position.
     */
    public void undoRemove() {
        if (undoStack.isEmpty()) {
            NaviTextUi.printLineSeparator();
            System.out.println("No recent deletions to undo.");
            NaviTextUi.printLineSeparator();
            return;
        }
        Pair<Integer, String> lastRemoved = undoStack.pop();
        int originalIndex = lastRemoved.getKey();
        String restoredItem = lastRemoved.getValue();

        favoriteItems.add(originalIndex, restoredItem);
        saveFavorites();
        NaviTextUi.printLineSeparator();
        System.out.println("Restored: " + restoredItem);
        NaviTextUi.printLineSeparator();
    }

    /**
     * Returns a copy of the current favorites list.
     *
     * @return A list of favorite items.
     */
    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
    }

    /**
     * Displays all favorite items to the user.
     * Loads favorites from file if the list is currently empty.
     */
    public void viewFavorites() {
        if (favoriteItems.isEmpty()) {
            loadFavorites();
        }
        NaviTextUi.printLineSeparator();
        if (favoriteItems.isEmpty()) {
            System.out.println("No favorites yet.");
        } else {
            System.out.println("Your favorite items:");
            for (int i = 0; i < favoriteItems.size(); i++) {
                System.out.println((i + 1) + ". " + favoriteItems.get(i));
            }
        }
        NaviTextUi.printLineSeparator();
    }

    /**
     * Sorts the favorites list based on rating.
     *
     * @param descending If true, sorts in descending order. Otherwise, sorts in ascending order.
     */
    public void sortFavorites(boolean descending) {
        favoriteItems.sort((a, b) -> {
            int ratingA = Integer.parseInt(a.split("\\| Rating: ")[1].split(" ")[0]);
            int ratingB = Integer.parseInt(b.split("\\| Rating: ")[1].split(" ")[0]);
            return descending ? Integer.compare(ratingB, ratingA) : Integer.compare(ratingA, ratingB);
        });
        saveFavorites();
        NaviTextUi.printLineSeparator();
        System.out.println("Favorites sorted in " + (descending ? "descending" : "ascending") + " order.");
        NaviTextUi.printLineSeparator();
    }

    /**
     * Searches for favorite items containing the given keyword.
     *
     * @param keyword The search keyword.
     * @return True if matching items were found, false otherwise.
     */
    public boolean searchFavorites(String keyword) {
        keyword = keyword.trim();

        if (keyword.isEmpty()) {
            NaviTextUi.printLineSeparator();
            System.out.println("Please enter a valid search term.");
            return false;
        }

        NaviTextUi.printLineSeparator();
        System.out.println("Search results for '" + keyword + "':");
        NaviTextUi.printLineSeparator();

        boolean found = false;
        for (String item : favoriteItems) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching favorites found.");
        }

        return found;
    }

}


