package seedu.navi.canteenfinder.nus;

import seedu.navi.canteenfinder.nus.landmark.Landmark;
import seedu.navi.canteenfinder.nus.landmark.canteen.Canteen;

import java.util.ArrayList;

// this class will do the searching
public class NUS {
    private final ArrayList<Landmark> landmarks;
    private final ArrayList<Canteen> canteens;

    public NUS() {
        landmarks = new ArrayList<>();
        canteens = new ArrayList<>();
    }

    public void addLandmark(Landmark landmark) {
        landmarks.add(landmark);
    }

    public void addCanteen(Canteen canteen) {
        canteens.add(canteen);
    }
}
