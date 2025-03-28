package seedu.navi.canteen.canteenfinder.nearestcanteendata;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;

public record NearestCanteenData(Canteen nearestCanteen, Integer landmarkToCanteenDist,
                                 ArrayList<String> validStalls) {
}
