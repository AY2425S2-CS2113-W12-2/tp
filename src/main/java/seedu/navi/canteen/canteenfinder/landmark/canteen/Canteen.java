package seedu.navi.canteen.canteenfinder.landmark.canteen;

import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

/**
 * The Canteen class represents a canteen within the system. It stores information about the canteen's
 * name and the list of stalls it contains. This class provides methods to add stalls, retrieve all stalls,
 * and find stalls that match user-specified criteria.
 * <p>
 * Each canteen maintains a list of {@link Stall} objects and supports operations to validate stalls based
 * on search type (OR or AND) and user-provided criteria.
 *
 * @see #name
 * @see #stalls
 * @see #findValidStalls(boolean, String[])
 */
public class Canteen {
    private String name;
    private ArrayList<Stall> stalls;

    /**
     * Constructs a new {@link Canteen} object with the specified name.
     *
     * @param name The name of the canteen.
     */
    public Canteen(String name) {
        this.name = name;
        this.stalls = new ArrayList<>();
    }

    /**
     * Returns the name of the canteen.
     *
     * @return A string representing the name of the canteen.
     */
    public String getName() {
        return name;
    }
    /**
     * Adds a stall to the list of stalls within this canteen.
     *
     * @param stall The {@link Stall} object to be added.
     */
    public void addStall(Stall stall) {
        stalls.add(stall);
    }

    /**
     * Retrieves the list of all stalls within this canteen.
     *
     * @return An {@link ArrayList} of {@link Stall} objects representing all the stalls in the canteen.
     */
    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    /**
     * Finds all stalls within this canteen that match the user's criteria.
     * <p>
     * This method iterates through the list of stalls and checks if each stall satisfies the user's
     * search type (OR or AND) and criteria. If a stall is valid, it is added to the result list.
     *
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @param canteenCriteria An array of strings representing the user's canteen criteria.
     * @return An {@link ArrayList} of {@link Stall} objects representing the valid stalls that match
     *         the user's criteria. Returns an empty list if no valid stalls are found.
     * @see Stall#isValidStall(boolean, String[])
     */
    public ArrayList<Stall> findValidStalls(boolean isOrSearchType, String[] canteenCriteria) {
        ArrayList<Stall> validStalls = new ArrayList<>();
        for (Stall stall : stalls) {
            if (stall.isValidStall(isOrSearchType, canteenCriteria)) {
                validStalls.add(stall);
            }
        }
        return validStalls;
    }
}
