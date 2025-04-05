package seedu.navi.canteen.canteenfinder.canteenfinderparser;

import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.exceptions.EmptyCanteenCriteria;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.EmptyUserLocation;


public class CanteenFinderParser {

    public static UserFields parseCanteenFinderCommand(String command)
            throws EmptyCanteenFinderCommand, EmptyUserLocation {
        if (command.isEmpty()) {
            throw new EmptyCanteenFinderCommand();
        }

        String[] commands = command.split("c/");
        if (commands.length == 0) {
            throw new EmptyCanteenFinderCommand();
        }
        if (commands[0].isEmpty()) {
            throw new EmptyUserLocation();
        }
        if (commands.length == 1) {
            throw new EmptyCanteenCriteria();
        }

        String userLocation = commands[0].trim();
        String[] canteenCriteria;
        canteenCriteria = CanteenCriterionParser.handleCanteenCriterion(commands[1]);

        assert canteenCriteria == null || canteenCriteria.length > 0 :
                "Output canteenCriteria should either be null or non-empty.";

        return new UserFields(userLocation, canteenCriteria);
    }
}

