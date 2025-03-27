package seedu.navi.canteenfinder.helperclasses;

import seedu.navi.exceptions.DuplicateDietRestrictions;
import seedu.navi.exceptions.EmptyDietRestriction;
import seedu.navi.exceptions.InvalidDietRestrictions;

import java.util.HashSet;
import java.util.Set;

public class DietRestrictionParser {

    private static void verifyDietRestrictions(String[] dietRestrictions)
            throws IllegalArgumentException, DuplicateDietRestrictions {
        Set<String> uniqueRestrictions = new HashSet<>();
        boolean isNILPresent = false;
        String[] validDietRestrictions = new String[dietRestrictions.length];

        for (int i = 0; i < dietRestrictions.length; i++) {
            String lowerCaseRestriction = dietRestrictions[i].toLowerCase().trim();
            String validDietRestriction = UserShortcuts.DIET_RESTRICTIONS_MAP.get(lowerCaseRestriction);
            if (validDietRestriction == null) {
                throw new IllegalArgumentException();
            }
            // Check for duplicates
            if (!uniqueRestrictions.add(validDietRestriction)) {
                throw new DuplicateDietRestrictions();
            }
            if ("nil".equals(validDietRestriction)) {
                isNILPresent = true;
            }
            validDietRestrictions[i] = validDietRestriction;
        }
        if (isNILPresent && uniqueRestrictions.size() > 1) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(validDietRestrictions, 0, dietRestrictions, 0, validDietRestrictions.length);
    }

    public static String[] handleDietRestrictions(String dietRestriction) throws EmptyDietRestriction,
            InvalidDietRestrictions, IllegalArgumentException, DuplicateDietRestrictions {
        if (dietRestriction.isEmpty()) {
            throw new EmptyDietRestriction();
        }

        String[] dietRestrictions = dietRestriction.split(", ");
        assert dietRestrictions.length != 0 : "dietRestrictions should not be empty";

        try {
            verifyDietRestrictions(dietRestrictions);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } catch (DuplicateDietRestrictions e) {
            throw new DuplicateDietRestrictions();
        }
        if (dietRestrictions[0].trim().equalsIgnoreCase("nil")) {
            dietRestrictions = null;
        }
        return dietRestrictions;
    }
}
