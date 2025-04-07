package seedu.navi.canteen.canteenfinder.canteencrtierionparser;

import seedu.navi.canteen.usershortcuts.CanteenCriteriaShortcuts;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.HCAndMOCriteriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.NILWithOtherCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * The CanteenCriterionParser class is responsible for parsing and validating canteen criteria
 * provided by the user. It ensures that the criteria are valid, non-duplicate, and conform to
 * specific rules based on the search type (OR or AND).
 */
public class CanteenCriterionParser {
    /**
     * Verifies an array of canteen criteria to ensure they are valid and meet specific constraints.
     * The url argument must specify an absolute {@link URL}. The name argument is a specifier that
     * is relative to the url argument.
     * <p>
     * This method always validates the input and throws appropriate exceptions if any criteria are
     * invalid, duplicated, or violate specific rules. It uses a {@link HashSet} to detect duplicates
     * and checks for conflicts such as "NIL" with other criteria or "Halal Certified" with "Muslim Owned".
     *
     * @param canteenCriteria An array of raw canteen criteria strings to be verified.
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @return A trimmed array of valid canteen criteria.
     * @throws NILWithOtherCriteria If "NIL" is used with other criteria.
     * @throws DuplicateCanteenCriterion If duplicate criteria are detected.
     * @throws InvalidCanteenCriteria If any criterion is invalid.
     * @see CanteenCriteriaShortcuts#CANTEEN_CRITERIA_MAP
     */
    private static String[] verifyCanteenCriteria(String[] canteenCriteria, boolean isOrSearchType)
            throws NILWithOtherCriteria, DuplicateCanteenCriterion, InvalidCanteenCriteria {
        Set<String> uniqueCriteria = new HashSet<>();
        String[] validCanteenCriteria = new String[canteenCriteria.length];

        boolean isNILPresent = false;
        boolean isHalalCertifiedPresent = false;
        boolean isMuslimOwnedPresent = false;

        assert canteenCriteria.length > 0 : "canteenCriteria array should not be empty.";

        int validIndex = 0;
        for (String canteenCriterion : canteenCriteria) {
            String lowerCaseCriterion = canteenCriterion.toLowerCase().trim();

            if (lowerCaseCriterion.isEmpty()) {
                continue;
            }
            String validCanteenCriterion = CanteenCriteriaShortcuts.CANTEEN_CRITERIA_MAP.get(lowerCaseCriterion);

            if (validCanteenCriterion == null) {
                throw new InvalidCanteenCriteria();
            }
            // Check for duplicates
            if (!uniqueCriteria.add(validCanteenCriterion)) {
                throw new DuplicateCanteenCriterion();
            }
            if ("nil".equals(validCanteenCriterion)) {
                isNILPresent = true;
            }
            if ("halal certified".equals(validCanteenCriterion)) {
                isHalalCertifiedPresent = true;
            }
            if ("muslim owned".equals(validCanteenCriterion)) {
                isMuslimOwnedPresent = true;
            }
            validCanteenCriteria[validIndex++] = validCanteenCriterion;
        }
        String[] trimmedValidCanteenCriteria = new String[validIndex];
        System.arraycopy(validCanteenCriteria, 0, trimmedValidCanteenCriteria, 0, validIndex);

        if (!isOrSearchType && isHalalCertifiedPresent && isMuslimOwnedPresent) {
            throw new HCAndMOCriteriaError();
        }
        if (isNILPresent && uniqueCriteria.size() > 1) {
            throw new NILWithOtherCriteria();
        }
        return trimmedValidCanteenCriteria;
    }
    /**
     * Handles the parsing and validation of a single string containing multiple canteen criteria,
     * separated by commas. The url argument must specify an absolute {@link URL}. The name argument
     * is a specifier that is relative to the url argument.
     * <p>
     * This method splits the input string into individual criteria, validates them using
     * {@link #verifyCanteenCriteria(String[], boolean)}, and returns the processed criteria. If the
     * only valid criterion is "NIL", it returns null to indicate no specific criteria.
     *
     * @param canteenCriterion A comma-separated string of raw canteen criteria.
     * @param isOrSearchType A boolean indicating whether the search is OR-based (true) or
     *                       AND-based (false).
     * @return A trimmed array of valid canteen criteria, or null if the only valid criterion is "NIL".
     * @throws InvalidCanteenCriteria If the input string contains no valid criteria.
     * @throws NILWithOtherCriteria If "NIL" is used with other criteria.
     * @throws DuplicateCanteenCriterion If duplicate criteria are detected.
     * @see #verifyCanteenCriteria(String[], boolean)
     */
    public static String[] handleCanteenCriterion(String canteenCriterion, boolean isOrSearchType) throws
            InvalidCanteenCriteria, NILWithOtherCriteria, DuplicateCanteenCriterion {
        assert canteenCriterion != null : "canteenCriterion should not be null";
        String[] canteenCriteria = canteenCriterion.split(",");

        if (canteenCriteria.length == 0) {
            throw new InvalidCanteenCriteria();
        }
        String[] validCanteenCriteria = verifyCanteenCriteria(canteenCriteria, isOrSearchType);

        if (validCanteenCriteria.length == 1 && validCanteenCriteria[0].equalsIgnoreCase("nil")) {
            return null;
        }
        return validCanteenCriteria;
    }
}
