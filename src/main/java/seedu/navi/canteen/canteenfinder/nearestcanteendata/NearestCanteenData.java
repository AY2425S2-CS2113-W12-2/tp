package seedu.navi.canteen.canteenfinder.nearestcanteendata;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

/**
 * The NearestCanteenData record encapsulates the data related to the nearest canteen and its associated stalls.
 * <p>
 * This record stores information about the nearest canteen, the distance to that canteen, and a list of valid
 * stalls within the canteen that match the user's criteria.
 *
 * @param nearestCanteen The nearest {@link Canteen} object.
 * @param canteenDistance The distance to the nearest canteen as an integer.
 * @param validStalls A list of {@link Stall} objects that match the user's criteria.
 * @see Canteen
 * @see Stall
 */
public record NearestCanteenData(Canteen nearestCanteen, Integer canteenDistance,
                                 ArrayList<Stall> validStalls) {
}
