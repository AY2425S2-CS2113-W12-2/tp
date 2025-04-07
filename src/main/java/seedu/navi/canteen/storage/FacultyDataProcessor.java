package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Faculty;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidFacultyDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Processes faculty data and links each faculty to nearby canteens with specified distances.
 */
public class FacultyDataProcessor {

    private final Map<String, Canteen> canteenMap;


    /**
     * Constructs a {@code FacultyDataProcessor} with the provided canteen map.
     *
     * @param canteenMap A map of canteen names to their corresponding {@code Canteen} objects.
     * @throws AssertionError If {@code canteenMap} is null.
     */
    public FacultyDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    /**
     * Parses and processes data from faculty sources and populates the given list with faculty objects.
     * Each faculty may also be linked to their nearest canteens and distances.
     *
     * @param faculties The list to populate with {@code Faculty} objects.
     * @throws AssertionError If {@code faculties} is null.
     */
    public void processData(ArrayList<Faculty> faculties) {
        assert faculties != null : "Faculty list should not be null";

        List<String> facultyDataList = DataRetriever.getFacultyData();
        for (String facultyData : facultyDataList) {
            insertFacultyFromData(facultyData, faculties);
        }
    }


    /**
     * Parses a line of raw faculty data and inserts the resulting {@code Faculty} object into the list.
     *
     * @param facultyData The raw data line representing a faculty and its nearby canteens.
     * @param faculties   The list to populate with the parsed {@code Faculty}.
     * @throws InvalidFacultyDataException If the faculty name is missing or malformed.
     */
    private void insertFacultyFromData(String facultyData, ArrayList<Faculty> faculties) {
        assert facultyData != null : "Faculty data line should not be null";
        assert faculties != null : "Faculty list should not be null";

        String[] parts = facultyData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidFacultyDataException("Missing faculty name in: " + facultyData);
        }

        String facultyName = parts[0].trim();
        Faculty faculty = new Faculty(facultyName);
        faculties.add(faculty);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], faculty, facultyName);
    }

    /**
     * Processes a string containing canteen information and associates them with the given faculty.
     *
     * @param canteenDataString The string describing canteen names and distances.
     * @param faculty           The faculty to associate with the canteens.
     * @param facultyName       The name of the faculty (for exception messaging).
     */
    private void processCanteenData(String canteenDataString, Faculty faculty, String facultyName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, faculty, facultyName);
            } catch (InvalidFacultyDataException e) {
                // Skip this specific canteen entry
            }
        }
    }

    /**
     * Parses an individual canteen entry and updates the faculty with the canteen and its distance.
     *
     * @param canteenInfo  The raw canteen entry string (e.g., "Deck (150m)").
     * @param faculty      The faculty to associate with the canteen.
     * @param facultyName  The name of the faculty (for exception messaging).
     * @throws InvalidFacultyDataException If the canteen name is missing or the canteen cannot be found.
     */
    private void processCanteenInfo(String canteenInfo, Faculty faculty, String facultyName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidFacultyDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidFacultyDataException("Canteen '" + canteenName +
                    "' not found for faculty '" + facultyName + "'");
        }

        faculty.setNearestCanteens(canteen);
        faculty.setCanteenDistance(canteen, distance);
    }

    /**
     * Extracts the distance value from the parsed canteen parts.
     *
     * @param canteenParts The array resulting from splitting the canteen string.
     * @return The integer distance to the canteen, or 0 if not specified or invalid.
     * @throws AssertionError If {@code canteenParts} is null.
     */
    private int extractDistance(String[] canteenParts) {
        assert canteenParts != null : "Canteen parts should not be null";

        if (canteenParts.length <= 1) {
            return 0; // Default distance if not found
        }

        String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
        if (distancePart.isEmpty()) {
            return 0; // Default distance if not found
        }

        return Integer.parseInt(distancePart);
    }
}
