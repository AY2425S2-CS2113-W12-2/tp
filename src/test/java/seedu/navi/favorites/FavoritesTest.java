package seedu.navi.favorites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FavoritesTest {

    private Favorites favorites;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        favorites = new Favorites();
        favorites.clearFavorites();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void addFavorite_validItem_addsSuccessfully() {
        favorites.addFavorite("Pizza", 9, "Food");
        favorites.addFavorite("Sushi", 8, "Food");

        List<String> favoriteItems = favorites.getFavoriteItems();
        assertEquals(2, favoriteItems.size());
        assertTrue(favoriteItems.get(0).contains("Pizza"));
        assertTrue(favoriteItems.get(1).contains("Sushi"));
        assertTrue(outputStreamCaptor.toString().contains("Added"));
    }

    @Test
    void removeFavorite_validIndex_removesSuccessfully() {
        favorites.addFavorite("Burger", 7, "Food");
        favorites.removeFavorite(0);

        assertEquals(0, favorites.getFavoriteItems().size());
        assertTrue(outputStreamCaptor.toString().contains("Removed: Burger"));
    }

    @Test
    void removeFavorite_invalidIndex_showsError() {
        favorites.addFavorite("Salad", 6, "Food");
        favorites.removeFavorite(1); // Invalid index

        assertEquals(1, favorites.getFavoriteItems().size());
        assertTrue(outputStreamCaptor.toString().contains("Invalid index"));
    }

    @Test
    void undoRemove_withRemoval_restoresItem() {
        favorites.addFavorite("Pasta", 8, "Food");
        favorites.removeFavorite(0);
        favorites.undoRemove();

        assertEquals(1, favorites.getFavoriteItems().size());
        assertTrue(outputStreamCaptor.toString().contains("Restored: Pasta"));
    }

    @Test
    void undoRemove_withoutRemoval_showsError() {
        favorites.undoRemove();
        assertTrue(outputStreamCaptor.toString().contains("No recent deletions to undo"));
    }

    @Test
    void viewFavorites_emptyList_showsEmptyMessage() {
        favorites.viewFavorites();
        assertTrue(outputStreamCaptor.toString().contains("No favorites yet"));
    }

    @Test
    void viewFavorites_withItems_showsItems() {
        favorites.addFavorite("Ramen", 9, "Food");
        favorites.viewFavorites();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Your favorite items"));
        assertTrue(output.contains("Ramen"));
    }

    @Test
    void sortFavorites_descendingOrder_sortsCorrectly() {
        favorites.addFavorite("Burger", 7, "Food");
        favorites.addFavorite("Steak", 9, "Food");
        favorites.sortFavorites(true);

        List<String> sortedItems = favorites.getFavoriteItems();
        assertTrue(sortedItems.get(0).contains("Rating: 9"));
        assertTrue(sortedItems.get(1).contains("Rating: 7"));
    }

    @Test
    void sortFavorites_ascendingOrder_sortsCorrectly() {
        favorites.addFavorite("Steak", 9, "Food");
        favorites.addFavorite("Burger", 7, "Food");
        favorites.sortFavorites(false);

        List<String> sortedItems = favorites.getFavoriteItems();
        assertTrue(sortedItems.get(0).contains("Rating: 7"));
        assertTrue(sortedItems.get(1).contains("Rating: 9"));
    }

    @Test
    void searchFavorites_existingKeyword_findsItems() {
        favorites.addFavorite("Chicken Rice", 8, "Food");
        boolean found = favorites.searchFavorites("Chicken");

        assertTrue(found);
        assertTrue(outputStreamCaptor.toString().contains("Chicken Rice"));
    }

    @Test
    void searchFavorites_nonExistingKeyword_returnsFalse() {
        favorites.addFavorite("Pizza", 9, "Food");
        boolean found = favorites.searchFavorites("Burger");

        assertFalse(found);
        assertTrue(outputStreamCaptor.toString().contains("No matching favorites found"));
    }

    @Test
    void clearFavorites_removesAllItems() {
        favorites.addFavorite("Item1", 5, "Test");
        favorites.addFavorite("Item2", 6, "Test");
        favorites.clearFavorites();

        assertEquals(0, favorites.getFavoriteItems().size());
    }
}

