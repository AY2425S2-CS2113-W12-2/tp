package seedu.navi.canteenfinder.nus;

import seedu.navi.canteenfinder.nus.landmark.Landmark;
import seedu.navi.canteenfinder.storage.Storage;

import java.util.ArrayList;

// this class will do the searching
public class NUS {
    public static final ArrayList<Landmark> landmarks = new ArrayList<>();

    public NUS() {
        Storage.processDataFromFiles();
    }
}
