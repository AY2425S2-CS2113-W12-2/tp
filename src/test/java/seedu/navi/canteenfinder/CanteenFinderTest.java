package seedu.navi.canteenfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteen.canteenfinder.canteenfinder.CanteenFinder;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.exceptions.CanteenNotFound;
import seedu.navi.exceptions.LocationNotFound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class CanteenFinderTest {
    @BeforeEach
    public void setUp() {
        Storage.processDataFromFiles();
    }

    @Test
    public void testFindNearestCanteen_correctAndWithSOCWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "soc",
                null);
        assertEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctOrWithSOCWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "soc",
                null);
        assertEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongAndWithSOCWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "soc",
                null);
        assertNotEquals("Flavours", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctAndWithSOCWithCanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "soc",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctAndWithScienceWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "faculty of science",
                null);
        assertEquals("Frontier", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongAndWithScienceWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "faculty of science",
                null);
        assertNotEquals("Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctOrWithHSSMLWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "hssml",
                null);
        assertEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongOrWithHSSMLWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "hssml",
                null);
        assertNotEquals("Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctOrWithHSSMLWithcanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "hssml",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongOrWithHSSMLWithcanteenCriteria_success() {
        String[] canteenCriteria = {"halal certified", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "hssml",
                canteenCriteria);
        assertNotEquals("Terrace", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctAndWithEusoffWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "eusoff",
                null);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongOrWitEusoffWithNull_success() {
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "eusoff",
                null);
        assertNotEquals("Flavours", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctAndWithEusoffWithcanteenCriteria_success() {
        String[] canteenCriteria = {"vegetarian"};
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "eusoff",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_correctOrWithEusoffWithcanteenCriteria_success() {
        String[] canteenCriteria = {"vegetarian", "aircon"};
        NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(true, "eusoff",
                canteenCriteria);
        assertEquals("The Deck", nearestCanteenData.nearestCanteen().getName());
    }

    @Test
    public void testFindNearestCanteen_wrongAndWithEusoffWithcanteenCriteria_exceptionThrown() {
        String[] canteenCriteria = {"vegetarian", "aircon"};
        try {
            NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "eusoff",
                    canteenCriteria);
            fail();
        } catch (CanteenNotFound e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindNearestCanteen_invalidLandmark_exceptionThrown() {
        try {
            NearestCanteenData nearestCanteenData = CanteenFinder.findNearestCanteen(false, "hss",
                    null);
            fail();
        } catch (LocationNotFound e) {
            assertTrue(true);
        }
    }
}
