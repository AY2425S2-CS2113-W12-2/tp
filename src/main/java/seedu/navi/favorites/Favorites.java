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
        assert item != null && !item.trim().isEmpty() : "Item should not be null or empty";


        favoriteItems.add(item);
        System.out.println("Added '" + item + "' to your favorites.");
    }

    // Removes an item from favorites
    public void removeFavorite(String item) {
        assert item != null && !item.trim().isEmpty() : "Item should not be null or empty";

        if (favoriteItems.remove(item)) {
            System.out.println("Removed '" + item + "' from your favorites.");
        } else {
            System.out.println("⚠️ Item not found in favorites.");
        }
    }

    public List<String> getFavoriteItems() {
        return new ArrayList<>(favoriteItems);
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
