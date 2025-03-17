package seedu.navi.favorites;
import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private List<String> favoriteItems;

    public Favorites() {
        this.favoriteItems = new ArrayList<>();
    }

    // Adds an item to favorites
    public void addFavorite(String item) {
        if (item == null || item.trim().isEmpty()) {
            System.out.println("⚠️ Invalid item. Please enter a valid item.");
            return;
        }
        favoriteItems.add(item);
        System.out.println("Added '" + item + "' to your favorites.");
    }

    // Removes an item from favorites
    public void removeFavorite(String item) {
        if (favoriteItems.remove(item)) {
            System.out.println("Removed '" + item + "' from your favorites.");
        } else {
            System.out.println("⚠️ Item not found in favorites.");
        }
    }

    // Views all favorite items
    public void viewFavorites() {
        if (favoriteItems.isEmpty()) {
            System.out.println("No favorites yet.");
        } else {
            System.out.println("🌟 Your favorite items:");
            for (String item : favoriteItems) {
                System.out.println("- " + item);
            }
        }
    }
}
