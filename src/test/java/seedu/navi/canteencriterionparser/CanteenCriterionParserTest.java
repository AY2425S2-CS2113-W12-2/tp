package seedu.navi.canteencriterionparser;

import org.junit.jupiter.api.Test;
import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.EmptyCanteenCriteria;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.NILWithOtherCriteria;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CanteenCriterionParserTest {
    @Test
    public void testHandleCanteenCriterion_halalCertified_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("halal certified");
        String[] actualCriteria = {"halal certified"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hc_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc");
        String[] actualCriteria = {"halal certified"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hcAndAircon_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc, aircon");
        String[] actualCriteria = {"halal certified", "aircon"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hcAndHalalCertified_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc, halal certified");
            fail();
        } catch (DuplicateCanteenCriterion e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_noInput_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("");
            fail();
        } catch (EmptyCanteenCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_noInputs_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion(",");
            fail();
        } catch (InvalidCanteenCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_invalidInputs_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("h");
            fail();
        } catch (InvalidCanteenCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_nilWithOtherCriteria_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("nil, hc");
            fail();
        } catch (NILWithOtherCriteria e) {
            assertTrue(true);
        }
    }
}
