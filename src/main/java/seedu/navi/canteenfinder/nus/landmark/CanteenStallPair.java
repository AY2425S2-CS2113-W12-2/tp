//test code
package seedu.navi.canteenfinder.nus.landmark;

import seedu.navi.canteenfinder.nus.landmark.canteen.Canteen;
import seedu.navi.canteenfinder.nus.landmark.canteen.stall.Stall;

public class CanteenStallPair {
    private final Canteen canteen;
    private final Stall stall;

    public CanteenStallPair(Canteen canteen, Stall stall) {
        this.canteen = canteen;
        this.stall = stall;
    }

    public Canteen getCanteen() {
        return canteen;
    }

    public Stall getStall() {
        return stall;
    }
}
