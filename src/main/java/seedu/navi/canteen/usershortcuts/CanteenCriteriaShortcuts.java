package seedu.navi.canteen.usershortcuts;

import java.util.HashMap;

public class CanteenCriteriaShortcuts {
    public static final HashMap<String, String> CANTEEN_CRITERIA_MAP = new HashMap<>();

    static {
        CANTEEN_CRITERIA_MAP.put("halal certified", "halal certified");
        CANTEEN_CRITERIA_MAP.put("hc", "halal certified");
        CANTEEN_CRITERIA_MAP.put("muslim owned", "muslim owned");
        CANTEEN_CRITERIA_MAP.put("mo", "muslim owned");
        CANTEEN_CRITERIA_MAP.put("vegetarian", "vegetarian");
        CANTEEN_CRITERIA_MAP.put("v", "vegetarian");
        CANTEEN_CRITERIA_MAP.put("aircon", "aircon");
        CANTEEN_CRITERIA_MAP.put("a", "aircon");
        CANTEEN_CRITERIA_MAP.put("nil", "nil");
    }
}
