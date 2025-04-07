package seedu.navi.canteen.usershortcuts;

import java.util.HashMap;

/**
 * The CanteenShortcuts class provides a mapping of shorthand notations and alternative names to their
 * full-form canteen names. This class is used to standardize user input by converting shorthand or
 * alternative names into their canonical forms.
 * <p>
 * The class contains a static {@link HashMap} named {@code CANTEEN_MAP}, which maps user-friendly shortcuts
 * (e.g., "techno", "pgp") to their corresponding full-form canteen names (e.g., "Techno Edge", "PGP Canteen").
 * The map is initialized statically and is immutable once created.
 *
 * @see #CANTEEN_MAP
 */
public class CanteenShortcuts {
    public static final HashMap<String, String> CANTEEN_MAP = new HashMap<>();

    static {
        CANTEEN_MAP.put("techno edge", "Techno Edge");
        CANTEEN_MAP.put("techno", "Techno Edge");
        CANTEEN_MAP.put("te", "Techno Edge");
        CANTEEN_MAP.put("frontier", "Frontier");
        CANTEEN_MAP.put("fr", "Frontier");
        CANTEEN_MAP.put("the deck", "The Deck");
        CANTEEN_MAP.put("deck", "The Deck");
        CANTEEN_MAP.put("d", "The Deck");
        CANTEEN_MAP.put("terrace", "Terrace");
        CANTEEN_MAP.put("t", "Terrace");
        CANTEEN_MAP.put("prince george's park canteen", "PGP Canteen");
        CANTEEN_MAP.put("pgp canteen", "PGP Canteen");
        CANTEEN_MAP.put("pgp", "PGP Canteen");
        CANTEEN_MAP.put("fine food", "Fine Food");
        CANTEEN_MAP.put("ff", "Fine Food");
        CANTEEN_MAP.put("flavours", "Flavours");
        CANTEEN_MAP.put("fl", "Flavours");
    }
}
