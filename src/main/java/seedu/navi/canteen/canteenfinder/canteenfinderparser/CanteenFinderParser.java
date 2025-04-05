package seedu.navi.canteen.canteenfinder.canteenfinderparser;

import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.InvalidSearchType;
import seedu.navi.exceptions.MissingCanteenFinderFields;


public class CanteenFinderParser {

    public static UserFields parseCanteenFinderCommand(String command)
            throws EmptyCanteenFinderCommand, MissingCanteenFinderFields {
        if (command.isEmpty()) {
            throw new EmptyCanteenFinderCommand();
        }
        String[] commands = command.split("\\|");

        if (commands.length != 3 || commands[1].trim().isEmpty()) {
            throw new MissingCanteenFinderFields();
        }
        boolean isOrSearchType;

        if (commands[0].trim().equals("1")) {
            isOrSearchType = true;
        } else if (commands[0].trim().equals("2")) {
            isOrSearchType = false;
        } else {
            throw new InvalidSearchType();
        }
        String userLocation = commands[1].trim();
        String[] canteenCriteria;
        canteenCriteria = CanteenCriterionParser.handleCanteenCriterion(commands[2]);

        assert canteenCriteria == null || canteenCriteria.length > 0 :
                "Output canteenCriteria should either be null or non-empty.";

        return new UserFields(isOrSearchType, userLocation, canteenCriteria);
    }
}

