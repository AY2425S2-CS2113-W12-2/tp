package seedu.navi.favorites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Favorites {
    private static final String FILE_NAME = "favorites.dat";
    private static final int MAX_RATING = 10;
    private static final int MIN_RATING = 0;

    private final List<String> favoriteItems;
    private final Stack<String> undoStack;

    /**
     * Initializes a new Favorites instance, loading saved items from file.
     */
    public Favorites() {
        this.favoriteItems = loadFavorites();
        this.undoStack = new Stack<>();
    }

    // Adds an item with description, rating, and category
    public void addFavorite(String description, int rating, String category) {
        String item = description + " | Rating: " + rating + " | Category: " + category;
        favoriteItems.add(item);
        saveFavorites(); // Save after adding an item
        System.out.println("✅ Added: " + item);
    }



    // Removes an item by index
    public void removeFavorite(int index) {
        if (index < 0 || index >= favoriteItems.size()) {
            System.out.println("⚠️ Invalid index.");
            return;
        }
        String removedItem = favoriteItems.remove(index);
        undoStack.push(removedItem);
        saveFavorites(); // Save after removing an item
        System.out.println("❌ Removed: " + removedItem);
    }

    public void undoRemove() {
        if (undoStack.isEmpty()) {
            System.out.println("⚠️ No recent deletions to undo.");
            return;
        }

        String restoredItem = undoStack.pop();

        // Ensure the item is not already in the list
        if (!favoriteItems.contains(restoredItem)) {
            favoriteItems.add(restoredItem);
            saveFavorites(); // Save after restoring an item
            System.out.println("🔄 Restored: " + restoredItem);
        } else {
            System.out.println("❌ Item already in favorites.");
        }
    }

    public void clearFavorites() {
        favoriteItems.clear();  // Clears the list of favorite items
        undoStack.clear();      // Clears the undo stack
        System.out.println("🔄 Favorites and undo stack cleared.");
    }


    public void deleteItem(String item) {
        if (favoriteItems.remove(item)) {
            undoStack.push(item); // Push to undoStack when item is removed
            System.out.println("❌ Removed: " + item);
        } else {
            System.out.println("⚠️ Item not found: " + item);
        }
    }




    // Retrieves all favorite items
    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
    }

    // Views all favorite items
    public void viewFavorites() {
        if (favoriteItems.isEmpty()) {
            System.out.println("No favorites yet.");
        } else {
            System.out.println("🌟 Your favorite items:");
            for (int i = 0; i < favoriteItems.size(); i++) {
                System.out.println((i + 1) + ". " + favoriteItems.get(i));
            }
        }
    }

    // Sorts items based on rating in ascending or descending order
    public void sortFavorites(boolean descending) {
        favoriteItems.sort((a, b) -> {
            int ratingA = Integer.parseInt(a.split("\\| Rating: ")[1].split(" ")[0]);
            int ratingB = Integer.parseInt(b.split("\\| Rating: ")[1].split(" ")[0]);
            return descending ? Integer.compare(ratingB, ratingA) : Integer.compare(ratingA, ratingB);
        });
        saveFavorites(); // Save after sorting
        System.out.println("📊 Favorites sorted in " + (descending ? "descending" : "ascending") + " order.");
        System.out.println("🌟 Your favorite items:");
        for (int i = 0; i < favoriteItems.size(); i++) {
            System.out.println((i + 1) + ". " + favoriteItems.get(i));
        }

    }

    // Searches for items containing a keyword and returns whether any were found
    public boolean searchFavorites(String keyword) {
        System.out.println("🔎 Search results for '" + keyword + "':");
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
        return found; // Return true if any results were found, otherwise false
    }


    private void saveFavorites() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(favoriteItems);  // favoriteItems is already a List<String>, so this is fine
        } catch (IOException e) {
            System.out.println("⚠️ Error saving favorites: " + e.getMessage());
        }
    }

    private List<String> loadFavorites() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>(); // Return an empty list if no file exists
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Cast the result to the correct type
            return (List<String>) ois.readObject();  // Ensure that the cast is safe
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ Error loading favorites: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list if loading fails
        }
    }
}

