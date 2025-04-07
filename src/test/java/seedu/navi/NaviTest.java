package seedu.navi;

import org.junit.jupiter.api.Test;
import seedu.navi.textui.NaviTextUi;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NaviTest {
    @Test
    void testShowExitMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        NaviTextUi.printExitMessage();

        String expectedOutput = """
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Ah, you’re heading off? No worries!
                We’ll catch you next time!
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                """;
        String actualOutput = outContent.toString().replace("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);
    }
}
