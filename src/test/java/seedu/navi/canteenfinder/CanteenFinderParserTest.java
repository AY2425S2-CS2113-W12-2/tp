package seedu.navi.canteenfinder;

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
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("soc",
                null);
        assertEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenSOC_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("soc",
                null);
        assertNotEquals("Flavours", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOCWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("soc",
                dietRestrictions);
        assertEquals("The Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenScience_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("faculty of science",
                null);
        assertEquals("Frontier", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenScience_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("faculty of science",
                null);
        assertNotEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSML_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("hssml",
                null);
        assertEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSML_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("hssml",
                null);
        assertNotEquals("Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertEquals("The Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenHSSMLWithDietRestrictions_success() {
        String[] dietRestrictions = {"halal certified", "aircon"};
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("hssml",
                dietRestrictions);
        assertNotEquals("Terrace", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoff_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                null);
        assertEquals("The Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoff_success() {
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                null);
        assertNotEquals("Flavours", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian"};
        Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                dietRestrictions);
        assertEquals("The Deck", actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenEusoffWithDietRestrictions_success() {
        String[] dietRestrictions = {"vegetarian", "aircon"};
        try {
            Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("eusoff",
                    dietRestrictions);
            fail();
        } catch (CanteenNotFound e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindNearestCanteenToMe_invalidLandmark_exceptionThrown() {
        try {
            Canteen actualCanteen = CanteenFinderParser.findNearestCanteenToMe("hss",
                    null);
            fail();
        } catch (LocationNotFound e) {
            assertTrue(true);
        }
    }
}
