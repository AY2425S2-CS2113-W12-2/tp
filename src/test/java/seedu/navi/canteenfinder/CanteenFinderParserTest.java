package seedu.navi.canteenfinder;

import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class CanteenFinderParserTest {
    @BeforeEach
    public void setUp() {
        Storage.processDataFromFiles();
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOC_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("soc",
                null);
        assertEquals("Terrace", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenSOC_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("soc",
                null);
        assertNotEquals("Flavours", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOCWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("soc",
                dietRestrictions);
        assertEquals("The Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenScience_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("faculty of science",
                null);
        assertEquals("Frontier", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenScience_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("faculty of science",
                null);
        assertNotEquals("Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSML_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("hssml",
                null);
        assertEquals("Terrace", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSML_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("hssml",
                null);
        assertNotEquals("Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertEquals("The Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertNotEquals("Terrace", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoff_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                null);
        assertEquals("The Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoff_success() {
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                null);
        assertNotEquals("Flavours", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian"};
        Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                dietRestrictions);
        assertEquals("The Deck", canteenDistPair.getKey().getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoffWithDietRestrictions_exceptionThrown() {
        String[] dietRestrictions = {"vegetarian", "aircon"};
        try {
            Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                    dietRestrictions);
            fail();
        } catch (CanteenNotFound e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindNearestCanteenToMe_invalidLandmark_exceptionThrown() {
        try {
            Pair<Canteen, Integer> canteenDistPair = CanteenFinderParser.findNearestCanteenToMe("hss",
                    null);
            fail();
        } catch (LocationNotFound e) {
            assertTrue(true);
        }
    }
}
