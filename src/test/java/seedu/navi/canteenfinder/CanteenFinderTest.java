package seedu.navi.canteenfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.LandmarkNotInStorage;
import seedu.navi.exceptions.LocationNotFound;
import seedu.navi.storage.Storage;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSML_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("hssml",
                null);
        assertEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSML_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("hssml",
                null);
        assertNotEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertNotEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoff_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("eusoff",
                null);
        assertEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoff_success() {
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("eusoff",
                null);
        assertNotEquals("Flavours", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian"};
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("eusoff",
                dietRestrictions);
        assertEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian", "aircon"};
        try {
            Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("eusoff",
                    dietRestrictions);
            fail();
        } catch (LandmarkNotInStorage e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindNearestCanteenToMe_invalidLandmark_exceptionThrown() {
        try {
            Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("hss",
                    null);
            fail();
        } catch (LocationNotFound e) {
            assertTrue(true);
        }
    }
}
