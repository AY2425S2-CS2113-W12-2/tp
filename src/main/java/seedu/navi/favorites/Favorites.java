package seedu.navi.favorites;

import seedu.navi.textui.TextUi;

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
        TextUi.printLineSeparator();
        System.out.println("✅ Added: " + item);
        TextUi.printLineSeparator();
    }

    // Removes an item by index
    public void removeFavorite(int index) {
        if (index < 0 || index >= favoriteItems.size()) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ Invalid index.");
            TextUi.printLineSeparator();
            return;
        }
        String removedItem = favoriteItems.remove(index);
        undoStack.push(removedItem);
        TextUi.printLineSeparator();
        System.out.println("❌ Removed: " + removedItem);
        TextUi.printLineSeparator();
    }

    // Undo the last deletion
    public void undoRemove() {
        if (undoStack.isEmpty()) {
            TextUi.printLineSeparator();
            System.out.println("⚠️ No recent deletions to undo.");
            TextUi.printLineSeparator();
            return;
        }
        String restoredItem = undoStack.pop();
        favoriteItems.add(restoredItem);
        TextUi.printLineSeparator();
        System.out.println("🔄 Restored: " + restoredItem);
        TextUi.printLineSeparator();
    }

    // Retrieves all favorite items
    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
    }

    // Views all favorite items
    public void viewFavorites() {
        if (favoriteItems.isEmpty()) {
            TextUi.printLineSeparator();
            System.out.println("No favorites yet.");
            TextUi.printLineSeparator();
        } else {
            System.out.println("🌟 Your favorite items:");
            for (int i = 0; i < favoriteItems.size(); i++) {
                TextUi.printLineSeparator();
                System.out.println((i + 1) + ". " + favoriteItems.get(i));
                TextUi.printLineSeparator();
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
        TextUi.printLineSeparator();
        System.out.println("📊 Favorites sorted in " + (descending ? "descending" : "ascending") + " order.");
        TextUi.printLineSeparator();
    }

    // Searches for items containing a keyword
    public void searchFavorites(String keyword) {
        TextUi.printLineSeparator();
        System.out.println("🔎 Search results for '" + keyword + "':");
        TextUi.printLineSeparator();
        boolean found = false;
        for (String item : favoriteItems) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                TextUi.printLineSeparator();
                System.out.println(item);
                TextUi.printLineSeparator();
                found = true;
            }
        }
        if (!found) {
            TextUi.printLineSeparator();
            System.out.println("❌ No matching favorites found.");
            TextUi.printLineSeparator();
        }
    }
}
