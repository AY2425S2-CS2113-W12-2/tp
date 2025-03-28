package seedu.navi.canteen.canteenfinder.nearestcanteendata;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;

public record NearestCanteenData(Canteen nearestCanteen, Integer landmarkToCanteenDist,
                                 ArrayList<Stall> validStalls) {
}
