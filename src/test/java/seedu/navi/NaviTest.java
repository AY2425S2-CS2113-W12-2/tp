package seedu.navi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;


class NaviTest {
    @Test
    void testShowExitMessage() {
        Navi navi = new Navi();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        navi.showExitMessage();

        String expectedOutput = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Ahh, you’re headin’ off? No worries!\n" +
                "Keep on keepin’ on, and we’ll catch ya next time!\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        String actualOutput = outContent.toString().replace("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);
    }
}
