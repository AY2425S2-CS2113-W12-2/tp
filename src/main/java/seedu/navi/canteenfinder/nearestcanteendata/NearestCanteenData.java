package seedu.navi.canteenfinder.nearestcanteendata;

import seedu.navi.canteenfinder.canteen.Canteen;

import java.util.ArrayList;

public record NearestCanteenData(Canteen nearestCanteen, Integer landmarkToCanteenDist,
                                 ArrayList<String> validStalls) {
}
