package seedu.navi.canteenfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.helperclasses.NearestCanteenData;
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
    public void testFindNearestCanteen_correctCanteenSOC_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("soc",
                null);
        assertEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenSOC_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("soc",
                null);
        assertNotEquals("Flavours", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenSOCWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("soc",
                dietRestrictions);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenScience_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("faculty of science",
                null);
        assertEquals("Frontier", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenScience_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("faculty of science",
                null);
        assertNotEquals("Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenHSSML_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                null);
        assertEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenHSSML_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                null);
        assertNotEquals("Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                dietRestrictions);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                dietRestrictions);
        assertNotEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenEusoff_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                null);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenEusoff_success() {
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                null);
        assertNotEquals("Flavours", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                dietRestrictions);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenEusoffWithDietRestrictions_exceptionThrown() {
        String[] dietRestrictions = {"vegetarian", "aircon"};
        try {
            NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                    dietRestrictions);
            fail();
        } catch (CanteenNotFound e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindNearestCanteen_invalidLandmark_exceptionThrown() {
        try {
            NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hss",
                    null);
            fail();
        } catch (LocationNotFound e) {
            assertTrue(true);
        }
    }
}
