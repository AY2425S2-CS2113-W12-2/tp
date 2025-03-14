package seedu.navi.canteenfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.landmark.Faculty;
import seedu.navi.canteenfinder.landmark.Landmark;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;

import static org.junit.jupiter.api.Assertions.*;

class CanteenFinderTest {
    @BeforeEach
    public void setUp() {
        // Clear the LANDMARKS list before each test
        CanteenFinder.LANDMARKS.clear();

        // Create test landmarks and canteens
        Landmark soc = new Faculty("SOC");
        Landmark fass = new Faculty("FASS");

        Canteen canteen1 = new Canteen("Canteen1");
        Canteen canteen2 = new Canteen("Canteen2");
        Canteen canteen3 = new Canteen("Canteen3");
        Canteen canteen4 = new Canteen("Canteen4");
        Canteen canteen5 = new Canteen("Canteen5");

        soc.setNearestCanteens(canteen1);
        soc.setNearestCanteens(canteen2);
        soc.setNearestCanteens(canteen3);
        soc.setNearestCanteens(canteen4);
        soc.setNearestCanteens(canteen5);

        fass.setNearestCanteens(canteen2);
        fass.setNearestCanteens(canteen1);
        fass.setNearestCanteens(canteen3);
        fass.setNearestCanteens(canteen4);
        fass.setNearestCanteens(canteen5);

        // Add landmarks to the LANDMARKS list
        CanteenFinder.LANDMARKS.add(soc);
        CanteenFinder.LANDMARKS.add(fass);
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenSOC_success() {
        Canteen expectedCanteen = new Canteen("Canteen1");
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("soc");
        assertEquals(expectedCanteen.getName(), actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_wrongCanteenSOC_success() {
        Canteen expectedCanteen = new Canteen("Canteen5");
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("soc");
        assertNotEquals(expectedCanteen.getName(), actualCanteen.getName());
    }

    @Test
    public void testFindNearestCanteenToMe_correctCanteenFASS_success() {
        Canteen expectedCanteen = new Canteen("Canteen2");
        Canteen actualCanteen = CanteenFinder.findNearestCanteenToMe("fass");
        assertEquals(expectedCanteen.getName(), actualCanteen.getName());
    }
}
