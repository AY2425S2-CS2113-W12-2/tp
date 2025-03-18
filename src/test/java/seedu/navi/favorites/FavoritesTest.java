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
        favorites.addFavorite("Pizza");
        favorites.addFavorite("Sushi");

        List<String> favoriteItems = favorites.getFavoriteItems(); // Assuming a getter is added for testing
        assertEquals(2, favoriteItems.size());
        assertTrue(favoriteItems.contains("Pizza"));
        assertTrue(favoriteItems.contains("Sushi"));
    }

    @Test
    void addFavorite_nullOrEmpty_doesNotAdd() {
        favorites.addFavorite(null);
        assertEquals("⚠️ Invalid item. Please enter a valid item.", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset(); // Reset output capture
        favorites.addFavorite("   ");
        assertEquals("⚠️ Invalid item. Please enter a valid item.", outputStreamCaptor.toString().trim());

        assertEquals(0, favorites.getFavoriteItems().size()); // Assuming a getter
    }



    @Test
    void viewFavorites_noItems_showsEmptyMessage() {
        favorites.viewFavorites();
        assertEquals("No favorites yet.", outputStreamCaptor.toString().trim());
    }


}
