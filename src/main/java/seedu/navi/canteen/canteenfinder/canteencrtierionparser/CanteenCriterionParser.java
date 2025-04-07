package seedu.navi.canteen.canteenfinder.canteencrtierionparser;

import seedu.navi.canteen.usershortcuts.CanteenCriteriaShortcuts;
import seedu.navi.exceptions.DuplicateCanteenCriterion;
import seedu.navi.exceptions.HCAndMOCrtieriaError;
import seedu.navi.exceptions.InvalidCanteenCriteria;
import seedu.navi.exceptions.NILWithOtherCriteria;

import java.util.HashSet;
import java.util.Set;

public class CanteenCriterionParser {

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
            throw new HCAndMOCrtieriaError();
        }
        if (isNILPresent && uniqueCriteria.size() > 1) {
            throw new NILWithOtherCriteria();
        }
        return trimmedValidCanteenCriteria;
    }

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
