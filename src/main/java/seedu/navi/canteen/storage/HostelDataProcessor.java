package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidHostelDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Processes hostel data and maps each hostel to its nearest canteens.
 */
public class HostelDataProcessor {

    private final Map<String, Canteen> canteenMap;

    /**
     * Constructs a {@code HostelDataProcessor} using the provided canteen map.
     *
     * @param canteenMap A map containing canteen names and their corresponding {@code Canteen} objects.
     * @throws AssertionError If {@code canteenMap} is null.
     */
    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    /**
     * Processes hostel data and populates the given list with {@code Landmark} objects representing hostels.
     * Each hostel may also be linked with its nearest canteens and their distances.
     *
     * @param hostels The list to be populated with hostel landmarks.
     * @throws AssertionError If {@code hostels} is null.
     */
    public void processData(ArrayList<Landmark> hostels) {
        assert hostels != null : "Hostel list should not be null";

        List<String> hostelDataList = DataRetriever.getHostelData(); // Assume this never returns null
        for (String hostelData : hostelDataList) {
            try {
                insertHostelFromData(hostelData, hostels);
            } catch (InvalidHostelDataException e) {
                // Skipping invalid hostel data silently
            }
        }
    }

    /**
     * Parses a line of hostel data and inserts the resulting {@code Landmark} into the given list.
     *
     * @param hostelData The raw data line representing a hostel and its nearby canteens.
     * @param hostels    The list to populate with the parsed {@code Landmark}.
     * @throws InvalidHostelDataException If the hostel name is missing or malformed.
     */
    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        assert hostelData != null : "Hostel data line should not be null";
        assert hostels != null : "Hostel list should not be null";

        String[] parts = hostelData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidHostelDataException("Missing hostel name in: " + hostelData);
        }

        String hostelName = parts[0].trim();
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);

        if (parts.length <= 1) {
            return; // No canteen data, exit early
        }

        processCanteenData(parts[1], hostel, hostelName);
    }

    /**
     * Processes the string containing canteen data and associates the relevant canteens with the hostel.
     *
     * @param canteenDataString The raw string representing canteen information.
     * @param hostel            The hostel to link canteens to.
     * @param hostelName        The name of the hostel, used for error reporting.
     */
    private void processCanteenData(String canteenDataString, Landmark hostel, String hostelName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, hostel, hostelName);
            } catch (InvalidHostelDataException e) {
                // Skip this specific canteen info
            }
        }
    }

    /**
     * Parses individual canteen info and links the canteen and its distance to the given hostel.
     *
     * @param canteenInfo The raw string containing canteen name and distance (e.g. "Deck (200m)").
     * @param hostel      The hostel to associate with the canteen.
     * @param hostelName  The name of the hostel for error messages.
     * @throws InvalidHostelDataException If the canteen name is missing or the canteen is not found in the map.
     */
    private void processCanteenInfo(String canteenInfo, Landmark hostel, String hostelName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidHostelDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidHostelDataException("Canteen '" + canteenName +
                    "' not found for hostel '" + hostelName + "'");
        }

        hostel.setNearestCanteens(canteen);
        hostel.setCanteenDistance(canteen, distance);
    }

    /**
     * Extracts the distance from the canteen parts array.
     * If no distance is specified or cannot be parsed, defaults to 0.
     *
     * @param canteenParts An array split from the canteen info string.
     * @return The distance to the canteen, or 0 if not specified.
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
