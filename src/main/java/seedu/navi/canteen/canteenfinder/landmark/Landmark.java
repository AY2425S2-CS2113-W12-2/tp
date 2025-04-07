package seedu.navi.canteen.canteenfinder.landmark;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;
import seedu.navi.canteen.canteenfinder.nearestcanteendata.NearestCanteenData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Landmark class represents a specific location within the system, such as a building or hall.
 * It stores information about the nearest canteens, their distances, and provides methods to find
 * the nearest canteen that matches user-specified criteria.
 * <p>
 * Each landmark maintains a list of nearest canteens sorted by proximity and a map of distances
 * to those canteens. This class supports operations to add canteens, set distances, and retrieve
 * the nearest canteen based on user input.
 *
 * @see #nearestCanteens
 * @see #canteenDistances
 * @see #getNearestCanteen(boolean, String[])
 */
public class Landmark {
    protected String name;
    protected ArrayList<Canteen> nearestCanteens;
    protected Map<Canteen, Integer> canteenDistances; // Add distance storage

    /**
     * Constructs a new {@link Landmark} object with the specified name.
     *
     * @param name The name of the landmark.
     */
    public Landmark(String name) {
        this.name = name;
        nearestCanteens = new ArrayList<>();
        canteenDistances = new HashMap<>();
    }

    /**
     * Returns the name of the landmark.
     *
     * @return A string representing the name of the landmark.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a canteen to the list of nearest canteens for this landmark.
     *
     * @param canteen The {@link Canteen} object to be added.
     */
    public void setNearestCanteens(Canteen canteen) {
        nearestCanteens.add(canteen);
    }

    /**
     * Finds the nearest canteen that matches the user's criteria.
     * <p>
     * This method iterates through the list of nearest canteens and checks if any of them have
     * valid stalls that match the user's search type and criteria. If a matching canteen is found,
     * it returns a {@link NearestCanteenData} object containing the canteen, its distance, and
     * the list of valid stalls. Otherwise, it returns null.
     *
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @param canteenCriteria An array of strings representing the user's canteen criteria.
     * @return A {@link NearestCanteenData} object containing the nearest canteen, its distance,
     *         and valid stalls, or null if no matching canteen is found.
     * @see Canteen#findValidStalls(boolean, String[])
     */
    public NearestCanteenData getNearestCanteen(boolean isOrSearchType, String[] canteenCriteria) {
        for (Canteen nearestCanteen : nearestCanteens) {
            ArrayList<Stall> validStalls = nearestCanteen.findValidStalls(isOrSearchType, canteenCriteria);
            if (!validStalls.isEmpty()) {
                return new NearestCanteenData(nearestCanteen, canteenDistances.get(nearestCanteen), validStalls);
            }
        }
        return null;
    }

    /**
     * Sets the distance from this landmark to the specified canteen.
     *
     * @param canteen The {@link Canteen} object for which the distance is being set.
     * @param distance The distance from this landmark to the canteen as an integer.
     */
    public void setCanteenDistance(Canteen canteen, int distance) {
        canteenDistances.put(canteen, distance);
    }
    /**
     * Retrieves the distance from this landmark to the specified canteen.
     *
     * @param canteen The {@link Canteen} object for which the distance is being retrieved.
     * @return The distance as an integer, or -1 if the canteen is not found in the map.
     */
    public int getCanteenDistance(Canteen canteen) {
        return canteenDistances.getOrDefault(canteen, -1);
    }
}
