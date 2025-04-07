package seedu.navi.canteen.usershortcuts;

import java.util.HashMap;

/**
 * The CanteenCriteriaShortcuts class provides a mapping of shorthand notations to their full-form
 * canteen criteria. The url argument must specify an absolute {@link URL}. The name argument is a
 * specifier that is relative to the url argument.
 * <p>
 * This class contains a static {@link HashMap} named {@code CANTEEN_CRITERIA_MAP}, which maps user-friendly
 * shortcuts (e.g., "hc", "mo") to their corresponding full-form criteria (e.g., "halal certified",
 * "muslim owned"). The map is initialized statically and is immutable once created.
 *
 * @see #CANTEEN_CRITERIA_MAP
 */
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
