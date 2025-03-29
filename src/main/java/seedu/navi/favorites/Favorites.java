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

    public void clearFavorites() {
        favoriteItems.clear();
        undoStack.clear();
    }

    public void addFavorite(String description, int rating, String category) {
        String item = description + " | Rating: " + rating + " | Category: " + category;
        favoriteItems.add(item);
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
        favoriteItems.add(restoredItem);
        TextUi.printLineSeparator();
        System.out.println("🔄 Restored: " + restoredItem);
        TextUi.printLineSeparator();
    }

    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
    }

    public void viewFavorites() {
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

