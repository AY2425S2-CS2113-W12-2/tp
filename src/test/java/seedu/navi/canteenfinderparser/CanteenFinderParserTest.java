package seedu.navi.canteenfinderparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteen.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.MissingCanteenFinderFields;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CanteenFinderParserTest {
    @BeforeEach
    public void setUp() {
        Storage.processDataFromFiles();
    }

    @Test
    public void testParseCanteenFinderCommand_orWithSOCWithHC_success() {
        String command = "1 |soc | hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertTrue(userFields.isOrSearchType());
        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithTabCommaHC_success() {
        String command = "  2|soc |    ,hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertFalse(userFields.isOrSearchType());
        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_orWithSOCWithHCCommaTab_success() {
        String command = "1|    soc |hc,     ";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertTrue(userFields.isOrSearchType());
        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_andWithSOCWithTabCommaTabCommaHC_success() {
        String command = "2|soc |    ,   ,hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertFalse(userFields.isOrSearchType());
        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_blankWithHC_exceptionThrown() {
        String command = "1|    |hc";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (MissingCanteenFinderFields e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParseCanteenFinderCommand_orWithSOCWithBlank_exceptionThrown() {
        String command = "1|soc |";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (MissingCanteenFinderFields e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParseCanteenFinderCommand_blankWithBlank_exceptionThrown() {
        String command = "|";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (MissingCanteenFinderFields e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParseCanteenFinderCommand_blankWithBlankWithBlank_exceptionThrown() {
        String command = "||";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (MissingCanteenFinderFields e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParseCanteenFinderCommand_blank_exceptionThrown() {
        String command = "";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (EmptyCanteenFinderCommand e) {
            assertTrue(true);
        }
    }
}
