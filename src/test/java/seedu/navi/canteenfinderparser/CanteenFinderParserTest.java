package seedu.navi.canteenfinderparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteen.canteenfinder.canteenfinderparser.CanteenFinderParser;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.canteen.storage.Storage;
import seedu.navi.exceptions.EmptyCanteenCriteria;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.EmptyUserLocation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CanteenFinderParserTest {
    @BeforeEach
    public void setUp() {
        Storage.processDataFromFiles();
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithHC_success() {
        String command = "soc c/hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithTabCommaHC_success() {
        String command = "soc c/    ,hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithHCCommaTab_success() {
        String command = "soc c/hc,     ";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithTabCommaTabCommaHC_success() {
        String command = "soc c/    ,   ,hc";
        UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
        String[] actualCanteenCriteria = new String[]{"halal certified"};

        assertEquals("soc", userFields.userLocation());
        assertArrayEquals(actualCanteenCriteria, userFields.canteenCriteria());
    }

    @Test
    public void testParseCanteenFinderCommand_blankWithHC_exceptionThrown() {
        String command = "c/hc";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (EmptyUserLocation e) {
            assertTrue(true);
        }
    }

    @Test
    public void testParseCanteenFinderCommand_sOCWithBlank_exceptionThrown() {
        String command = "soc c/";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (EmptyCanteenCriteria e) {
            assertTrue(true);
        }
    }
    @Test
    public void testParseCanteenFinderCommand_blankWithBlank_exceptionThrown() {
        String command = "c/";
        try {
            UserFields userFields = CanteenFinderParser.parseCanteenFinderCommand(command);
            fail();
        } catch (EmptyCanteenFinderCommand e) {
            assertTrue(true);
        }
    }
}
