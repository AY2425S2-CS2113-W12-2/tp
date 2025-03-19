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
                Techno Edge | Chicken Rice | T | F | T | F
                The Deck | Noodle | F | T | F | T
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
        assert canteenMap.get("Techno Edge") != null;
        assert canteenMap.get("The Deck") != null;
        assert canteenMap.get("Fine Food") != null;
        assert canteenMap.get("Flavours") != null;
    }

    @Test
    public void testProcessDataFromFiles_canteenMapCanteenHasCorrectStalls() {
        Storage.processDataFromFiles();
        Map<String, Canteen> canteenMap = Storage.getCanteenMap();

        Canteen techno = canteenMap.get("Techno Edge");
        assert techno != null;
        assert techno.getStalls().stream().anyMatch(s -> s.getName().equals("Chicken Rice"));

        Canteen deck = canteenMap.get("The Deck");
        assert deck != null;
        assert deck.getStalls().stream().anyMatch(s -> s.getName().equals("Noodle"));

        Canteen fineFood = canteenMap.get("Fine Food");
        assert fineFood != null;
        assert fineFood.getStalls().stream().anyMatch(s -> s.getName().equals("Western Cuisine"));

        Canteen flavours = canteenMap.get("Flavours");
        assert flavours != null;
        assert flavours.getStalls().stream().anyMatch(s -> s.getName().equals("Mala Hotpot"));
    }

    @Test
    public void testProcessDataFromFiles_canteenMapStallHasCorrectAttributes() {
        Storage.processDataFromFiles();
        Map<String, Canteen> canteenMap = Storage.getCanteenMap();

        Canteen techno = canteenMap.get("Techno Edge");
        var stalls = techno.getStalls().stream();
        Stall chickenRice = stalls.filter(s -> s.getName().equals("Chicken Rice")).findFirst().orElse(null);
        assert chickenRice != null;
        StallCharacteristic chickenRiceChar = chickenRice.getStallCharacteristic();
        assert !chickenRiceChar.gethalalCertified();
        assert !chickenRiceChar.getMuslimOwned();
        assert !chickenRiceChar.getInAirconArea();
        assert !chickenRiceChar.getVegetarian();

        Canteen deck = canteenMap.get("The Deck");
        var noodleStalls = deck.getStalls().stream();
        Stall noodle = noodleStalls.filter(s -> s.getName().equals("Noodle")).findFirst().orElse(null);
        assert noodle != null;
        StallCharacteristic noodleChar = noodle.getStallCharacteristic();
        assert !noodleChar.gethalalCertified();
        assert !noodleChar.getMuslimOwned();
        assert !noodleChar.getInAirconArea();
        assert !noodleChar.getVegetarian();

        Canteen fineFood = canteenMap.get("Fine Food");
        var westernStalls = fineFood.getStalls().stream();
        Stall western = westernStalls.filter(s -> s.getName().equals("Western Cuisine")).findFirst().orElse(null);
        assert western != null;
        StallCharacteristic westernChar = western.getStallCharacteristic();
        assert westernChar.gethalalCertified();
        assert !westernChar.getMuslimOwned();
        assert westernChar.getInAirconArea();
        assert !westernChar.getVegetarian();

        Canteen flavours = canteenMap.get("Flavours");
        var malaStalls = flavours.getStalls().stream();
        Stall mala = malaStalls.filter(s -> s.getName().equals("Mala Hotpot")).findFirst().orElse(null);
        assert mala != null;
        StallCharacteristic malaChar = mala.getStallCharacteristic();
        assert !malaChar.gethalalCertified();
        assert !malaChar.getMuslimOwned();
        assert !malaChar.getInAirconArea();
        assert !malaChar.getVegetarian();
    }

    public static Map<String, Canteen> getCanteenMap() {
        return Storage.getCanteenMap();
    }
}
