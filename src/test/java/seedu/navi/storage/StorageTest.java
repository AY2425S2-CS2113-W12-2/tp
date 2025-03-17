package seedu.navi.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.navi.canteenfinder.CanteenFinder;
import seedu.navi.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteenfinder.landmark.canteen.stall.StallCharacteristic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StorageTest {

    private static final String TEST_DATA_DIR = "testdata/";
    private static final String CANTEEN_FILE = TEST_DATA_DIR + "canteen.txt";

    @BeforeEach
    public void setUp() throws IOException {
        CanteenFinder.LANDMARKS.clear();
        createTestDataFiles();
    }

    private void createTestDataFiles() throws IOException {
        Files.createDirectories(Paths.get(TEST_DATA_DIR));
        String canteenData = """
                Techno | Chicken Rice | T | F | T | F
                Deck | Noodle | F | T | F | T
                Fine Food | Western | T | T | T | F
                Flavours | Mala | F | F | F | T
                """;
        createFile(CANTEEN_FILE, canteenData);
    }

    private void createFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }

    @Test
    public void testProcessDataFromFiles_canteenMapContainsCorrectCanteens() {
        Storage.processDataFromFiles();
        Map<String, Canteen> canteenMap = Storage.getCanteenMap();
        assertNotNull(canteenMap.get("Techno"));
        assertNotNull(canteenMap.get("Deck"));
        assertNotNull(canteenMap.get("Fine Food"));
        assertNotNull(canteenMap.get("Flavours"));
    }

    @Test
    public void testProcessDataFromFiles_canteenMapCanteenHasCorrectStalls() {
        Storage.processDataFromFiles();
        Map<String, Canteen> canteenMap = Storage.getCanteenMap();

        Canteen techno = canteenMap.get("Techno");
        assertNotNull(techno);
        assertTrue(techno.getStalls().stream().anyMatch(s -> s.getName().equals("Chicken Rice")));

        Canteen deck = canteenMap.get("Deck");
        assertNotNull(deck);
        assertTrue(deck.getStalls().stream().anyMatch(s -> s.getName().equals("Noodle")));

        Canteen fineFood = canteenMap.get("Fine Food");
        assertNotNull(fineFood);
        assertTrue(fineFood.getStalls().stream().anyMatch(s -> s.getName().equals("Western Cuisine")));

        Canteen flavours = canteenMap.get("Flavours");
        assertNotNull(flavours);
        assertTrue(flavours.getStalls().stream().anyMatch(s -> s.getName().equals("Mala Hotpot")));
    }

    @Test
    public void testProcessDataFromFiles_canteenMapStallHasCorrectAttributes() {
        Storage.processDataFromFiles();
        Map<String, Canteen> canteenMap = Storage.getCanteenMap();

        Canteen techno = canteenMap.get("Techno");
        var stalls = techno.getStalls().stream();
        Stall chickenRice = stalls.filter(s -> s.getName().equals("Chicken Rice")).findFirst().orElse(null);
        assertNotNull(chickenRice);
        StallCharacteristic chickenRiceChar = chickenRice.getStallCharacteristic();
        assertFalse(chickenRiceChar.gethalalCertified());
        assertFalse(chickenRiceChar.getMuslimOwned());
        assertFalse(chickenRiceChar.getInAirconArea());
        assertFalse(chickenRiceChar.getVegetarian());

        Canteen deck = canteenMap.get("Deck");
        var noodleStalls = deck.getStalls().stream();
        Stall noodle = noodleStalls.filter(s -> s.getName().equals("Noodle")).findFirst().orElse(null);
        assertNotNull(noodle);
        StallCharacteristic noodleChar = noodle.getStallCharacteristic();
        assertFalse(noodleChar.gethalalCertified());
        assertFalse(noodleChar.getMuslimOwned());
        assertFalse(noodleChar.getInAirconArea());
        assertFalse(noodleChar.getVegetarian());


        Canteen fineFood = canteenMap.get("Fine Food");
        var westernStalls = fineFood.getStalls().stream();
        Stall western = westernStalls.filter(s -> s.getName().equals("Western Cuisine")).findFirst().orElse(null);
        assertNotNull(western);
        StallCharacteristic westernChar = western.getStallCharacteristic();
        assertTrue(westernChar.gethalalCertified());
        assertFalse(westernChar.getMuslimOwned());
        assertTrue(westernChar.getInAirconArea());
        assertFalse(westernChar.getVegetarian());

        Canteen flavours = canteenMap.get("Flavours");
        var malaStalls = flavours.getStalls().stream();
        Stall mala = malaStalls.filter(s -> s.getName().equals("Mala Hotpot")).findFirst().orElse(null);
        assertNotNull(mala);
        StallCharacteristic malaChar = mala.getStallCharacteristic();
        assertFalse(malaChar.gethalalCertified());
        assertFalse(malaChar.getMuslimOwned());
        assertFalse(malaChar.getInAirconArea());
        assertFalse(malaChar.getVegetarian());
    }

    public static Map<String, Canteen> getCanteenMap() {
        return Storage.getCanteenMap();
    }
}
