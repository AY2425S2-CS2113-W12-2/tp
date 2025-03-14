package seedu.navi.canteenfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class CanteenFinderTest {
    @BeforeEach
    public void setUp() {
        Storage.processDataFromFiles();
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOC_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("soc",
                null);
        assertEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenSOC_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("soc",
                null);
        assertNotEquals("Flavours", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOCWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("soc",
                dietRestrictions);
        assertEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenScience_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("faculty of science",
                null);
        assertEquals("Frontier", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenScience_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("faculty of science",
                null);
        assertNotEquals("Deck", actualCanteen.getName());
    }
}
