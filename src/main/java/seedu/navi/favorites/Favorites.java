package seedu.navi.favorites;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Favorites {
    private List<String> favoriteItems;
    private Stack<String> undoStack;

    public Favorites() {
        this.favoriteItems = new ArrayList<>();
        this.undoStack = new Stack<>();
    }

    // Adds an item with description, rating, and category
    public void addFavorite(String description, int rating, String category) {
        String item = description + " | Rating: " + rating + " | Category: " + category;
        favoriteItems.add(item);
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
        System.out.println("❌ Removed: " + removedItem);
    }

    // Undo the last deletion
    public void undoRemove() {
        if (undoStack.isEmpty()) {
            System.out.println("⚠️ No recent deletions to undo.");
            return;
        }
        String restoredItem = undoStack.pop();
        favoriteItems.add(restoredItem);
        System.out.println("🔄 Restored: " + restoredItem);
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
        System.out.println("📊 Favorites sorted in " + (descending ? "descending" : "ascending") + " order.");
    }

    // Searches for items containing a keyword
    public void searchFavorites(String keyword) {
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
    }
}
