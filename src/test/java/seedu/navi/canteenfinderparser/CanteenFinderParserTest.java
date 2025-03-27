package seedu.navi.canteenfinderparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteenfinder.nearestcanteendata.NearestCanteenData;
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
    public void testFindNearestCanteen_correctCanteenSOCWithCanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("soc",
                canteenCriteria);
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
    public void testFindNearestCanteen_correctCanteenHSSMLWithcanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenHSSMLWithcanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("hssml",
                canteenCriteria);
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
    public void testFindNearestCanteen_correctCanteenEusoffWithcanteenCriteria_success() {
        String[] canteenCriteria = {"vegetarian"};
        NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongCanteenEusoffWithcanteenCriteria_exceptionThrown() {
        String[] canteenCriteria = {"vegetarian", "aircon"};
        try {
            NearestCanteenData nearestCanteenData = CanteenFinderParser.findNearestCanteen("eusoff",
                    canteenCriteria);
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
