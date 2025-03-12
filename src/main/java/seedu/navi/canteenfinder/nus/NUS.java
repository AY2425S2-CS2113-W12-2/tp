package seedu.navi.canteenfinder.nus;

import seedu.navi.canteenfinder.nus.landmark.Landmark;

import java.util.ArrayList;

// this class will do the searching
public class NUS {
    private final ArrayList<Landmark> landmarks;

    public NUS() {
        landmarks = new ArrayList<>();
    }

    public void addLandmark(Landmark landmark) {
        landmarks.add(landmark);
    }

}
