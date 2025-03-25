package seedu.navi.favorites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void removeFavorite_invalidIndex_showsWarning() {
        favorites.removeFavorite(0);
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("⚠️ Invalid index."));
    }

    @Test
    void viewFavorites_noItems_showsEmptyMessage() {
        favorites.viewFavorites();
        assertEquals("No favorites yet.", outputStreamCaptor.toString().trim());
    }

    @Test
    void undoRemove_noRecentDeletion_showsErrorMessage() {
        favorites.undoRemove();
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("⚠️ No recent deletions to undo."));
    }

    @Test
    void undoRemove_afterValidDeletion_restoresItem() {
        favorites.addFavorite("Pasta", 8, "Food");
        favorites.removeFavorite(0);
        favorites.undoRemove();

        List<String> favoriteItems = favorites.getFavoriteItems();
        assertEquals(1, favoriteItems.size());
        assertTrue(favoriteItems.get(0).contains("Pasta"));

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("🔄 Restored: Pasta | Rating: 8 | Category: Food"));
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
        assertTrue(output.contains("🔎 Search results for 'Chicken':"));
        assertTrue(output.contains("Chicken Rice | Rating: 8 | Category: Food"));
        assertTrue(output.contains("Roast Chicken | Rating: 7 | Category: Food"));
    }

    @Test
    void searchFavorites_noResults_showsNoResultsMessage() {
        favorites.searchFavorites("Pasta");

        // Capture output and normalize it
        String output = outputStreamCaptor.toString().trim();

        // Debugging: Print output to console (remove later)
        System.out.println("Captured Output: " + output);

        // Check if output contains the expected message
        assertTrue(output.contains("❌ No matching favorites found."),
                "Expected '❌ No matching favorites found.' but got: " + output);
    }

}
