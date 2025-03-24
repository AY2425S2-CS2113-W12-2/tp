package seedu.navi.favorites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class FavoritesTest {

    private Favorites favorites;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        favorites = new Favorites();
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture console output
    }

    @Test
    void addFavorite_validItem_addsSuccessfully() {
        favorites.addFavorite("Pizza", 9, "Food");
        favorites.addFavorite("Sushi", 8, "Food");

        List<String> favoriteItems = favorites.getFavoriteItems(); // Assuming a getter is added for testing
        assertEquals(2, favoriteItems.size());
        assertTrue(favoriteItems.stream().anyMatch(item -> item.contains("Pizza")));
        assertTrue(favoriteItems.stream().anyMatch(item -> item.contains("Sushi")));
    }

    @Test
    void removeFavorite_validIndex_removesSuccessfully() {
        favorites.addFavorite("Burger", 7, "Food");
        favorites.removeFavorite(0);  // Remove first item

        List<String> favoriteItems = favorites.getFavoriteItems();
        assertTrue(favoriteItems.isEmpty());
    }

 

    @Test
    void viewFavorites_noItems_showsEmptyMessage() {
        favorites.viewFavorites();
        assertEquals("No favorites yet.", outputStreamCaptor.toString().trim());
    }

    @Test
    void viewFavorites_withItems_showsAllItems() {
        favorites.addFavorite("Pizza", 9, "Food");
        favorites.addFavorite("Sushi", 8, "Food");

        favorites.viewFavorites();
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("Pizza"));
        assertTrue(output.contains("Sushi"));
    }

    @Test
    void sortFavorites_descendingOrder_sortsCorrectly() {
        favorites.addFavorite("Burger", 7, "Food");
        favorites.addFavorite("Steak", 9, "Food");
        favorites.sortFavorites(true);

        List<String> sortedItems = favorites.getFavoriteItems();
        assertTrue(sortedItems.get(0).contains("Steak"));
        assertTrue(sortedItems.get(1).contains("Burger"));
    }

    @Test
    void sortFavorites_ascendingOrder_sortsCorrectly() {
        favorites.addFavorite("Burger", 7, "Food");
        favorites.addFavorite("Steak", 9, "Food");
        favorites.sortFavorites(false);

        List<String> sortedItems = favorites.getFavoriteItems();
        assertTrue(sortedItems.get(0).contains("Burger"));
        assertTrue(sortedItems.get(1).contains("Steak"));
    }

    @Test
    void searchFavorites_existingKeyword_findsItems() {
        favorites.addFavorite("Chicken Rice", 8, "Food");
        favorites.addFavorite("Roast Chicken", 7, "Food");

        favorites.searchFavorites("Chicken");
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("Chicken Rice") && output.contains("Roast Chicken"));
    }

    @Test
    void searchFavorites_noResults_showsNoResultsMessage() {
        favorites.searchFavorites("Pasta");
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("❌ No matching favorites found."));
    }

    @Test
    void undoRemove_restoresLastDeletedItem() {
        favorites.addFavorite("Noodles", 6, "Food");
        favorites.removeFavorite(0);  // Remove first item
        favorites.undoRemove();

        List<String> favoriteItems = favorites.getFavoriteItems();
        assertEquals(1, favoriteItems.size());
        assertTrue(favoriteItems.get(0).contains("Noodles"));
    }

    @Test
    void undoRemove_noRecentDeletion_showsErrorMessage() {
        favorites.undoRemove();  // No items removed yet
        assertEquals("⚠️ No recent deletions to undo.", outputStreamCaptor.toString().trim());
    }
}
