package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.exceptions.InvalidOtherBuildingDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Processes other building data and maps them to their nearest canteens.
 */
public class OtherBuildingDataProcessor {

    private final Map<String, Canteen> canteenMap;

    /**
     * Constructs an {@code OtherBuildingDataProcessor} with the given canteen map.
     *
     * @param canteenMap A map of canteen names to their corresponding {@code Canteen} objects.
     * @throws AssertionError If {@code canteenMap} is null.
     */
    public OtherBuildingDataProcessor(Map<String, Canteen> canteenMap) {
        assert canteenMap != null : "Canteen map should not be null";
        this.canteenMap = canteenMap;
    }

    /**
     * Populates the list of other buildings from raw data.
     * Each building will also be associated with its nearest canteens, if available.
     *
     * @param otherBuildings A list to populate with {@code Landmark} objects representing other buildings.
     * @throws AssertionError If {@code otherBuildings} is null.
     */
    public void processData(ArrayList<Landmark> otherBuildings) {
        assert otherBuildings != null : "Other building list should not be null";

        List<String> otherBuildingDataList = DataRetriever.getOtherBuildingData(); // Assume never null
        for (String otherBuildingData : otherBuildingDataList) {
            try {
                insertOtherBuildingFromData(otherBuildingData, otherBuildings);
            } catch (InvalidOtherBuildingDataException e) {
                // Skip invalid entry silently
            }
        }
    }

    /**
     * Parses a line of other building data and inserts the corresponding {@code Landmark} into the list.
     *
     * @param otherBuildingData The raw data line representing an other building and its canteens.
     * @param otherBuildings    The list to populate with the parsed {@code Landmark}.
     * @throws InvalidOtherBuildingDataException If the building name is missing or invalid.
     */
    private void insertOtherBuildingFromData(String otherBuildingData, ArrayList<Landmark> otherBuildings) {
        assert otherBuildingData != null : "Other building data line should not be null";
        assert otherBuildings != null : "Other building list should not be null";

        String[] parts = otherBuildingData.split(": ");
        if (parts.length == 0 || parts[0].trim().isEmpty()) {
            throw new InvalidOtherBuildingDataException("Missing other building name in: " + otherBuildingData);
        }

        String otherBuildingName = parts[0].trim();
        Landmark otherBuilding = new Landmark(otherBuildingName);
        otherBuildings.add(otherBuilding);

        if (parts.length <= 1) {
            return; // No canteen data
        }

        processCanteenData(parts[1], otherBuilding, otherBuildingName);
    }

    /**
     * Processes and associates canteen data for a given building.
     *
     * @param canteenDataString The string containing canteen details.
     * @param otherBuilding     The building to associate canteens with.
     * @param otherBuildingName The name of the building for error reporting.
     */
    private void processCanteenData(String canteenDataString, Landmark otherBuilding, String otherBuildingName) {
        assert canteenDataString != null : "Canteen data string should not be null";

        String[] canteenData = canteenDataString.split("\\|");
        for (String canteenInfo : canteenData) {
            try {
                processCanteenInfo(canteenInfo, otherBuilding, otherBuildingName);
            } catch (InvalidOtherBuildingDataException e) {
                // Skip this canteen info silently
            }
        }
    }

    /**
     * Parses canteen information and updates the building's nearest canteen and distance.
     *
     * @param canteenInfo       The raw string describing a canteen and its distance.
     * @param otherBuilding     The building to update.
     * @param otherBuildingName The name of the building for error reporting.
     * @throws InvalidOtherBuildingDataException If the canteen name is missing or not found in the canteen map.
     */
    private void processCanteenInfo(String canteenInfo, Landmark otherBuilding, String otherBuildingName) {
        assert canteenInfo != null : "Canteen info should not be null";

        String[] canteenParts = canteenInfo.trim().split("\\(");
        if (canteenParts.length == 0 || canteenParts[0].trim().isEmpty()) {
            throw new InvalidOtherBuildingDataException("Missing canteen name in: " + canteenInfo);
        }

        String canteenName = canteenParts[0].trim();
        int distance = extractDistance(canteenParts);
        Canteen canteen = canteenMap.get(canteenName);

        if (canteen == null) {
            throw new InvalidOtherBuildingDataException(
                    "Canteen '" + canteenName + "' not found for other building '" + otherBuildingName + "'");
        }

        otherBuilding.setNearestCanteens(canteen);
        otherBuilding.setCanteenDistance(canteen, distance);
    }

    /**
     * Extracts the distance value from a parsed canteen string.
     *
     * @param canteenParts An array of strings containing canteen name and optional distance.
     * @return The distance to the canteen, or 0 if not specified or invalid.
     * @throws AssertionError If {@code canteenParts} is null.
     */
    private int extractDistance(String[] canteenParts) {
        assert canteenParts != null : "Canteen parts should not be null";

        if (canteenParts.length <= 1) {
            return 0;
        }

        String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
        if (distancePart.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(distancePart);
    }
}
