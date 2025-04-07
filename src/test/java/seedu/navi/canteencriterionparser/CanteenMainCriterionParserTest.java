package seedu.navi.canteencriterionparser;

import org.junit.jupiter.api.Test;
import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.HCAndMOCriteriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.NILWithOtherCriteria;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CanteenMainCriterionParserTest {
    @Test
    public void testHandleCanteenCriterion_halalCertifiedWithAndType_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("halal certified", false);
        String[] actualCriteria = {"halal certified"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hcWithAndType_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc", false);
        String[] actualCriteria = {"halal certified"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hcAndAirconWithAndType_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc, aircon", false);
        String[] actualCriteria = {"halal certified", "aircon"};
        assertArrayEquals(actualCriteria, testCriteria);
    }

    @Test
    public void testHandleCanteenCriterion_hcAndHalalCertifiedWithAndType_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("hc, halal certified", false);
            fail();
        } catch (DuplicateCanteenCriterion e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_noInputsWithAndType_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion(",", false);
            fail();
        } catch (InvalidCanteenCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_invalidInputsWithAndType_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("h", false);
            fail();
        } catch (InvalidCanteenCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_nilWithOtherCriteriaWithAndType_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("nil, hc", false);
            fail();
        } catch (NILWithOtherCriteria e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_hCWithMOCriteriaWithAndType_exceptionThrown() {
        try {
            String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("mo, hc", false);
            fail();
        } catch (HCAndMOCriteriaError e) {
            assertTrue(true);
        }
    }

    @Test
    public void testHandleCanteenCriterion_hCWithMOCriteriaWithOrType_success() {
        String[] testCriteria = CanteenCriterionParser.handleCanteenCriterion("mo, hc", true);
        String[] actualCriteria = {"muslim owned", "halal certified"};
        assertArrayEquals(actualCriteria, testCriteria);
    }
}
