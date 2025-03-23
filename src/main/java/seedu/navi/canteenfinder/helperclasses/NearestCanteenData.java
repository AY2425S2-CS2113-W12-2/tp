package seedu.navi.canteenfinder.helperclasses;

import seedu.navi.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;

public record NearestCanteenData(Canteen nearestCanteen, Integer landmarkToCanteenDist,
                                 ArrayList<String> validStalls) {
}
