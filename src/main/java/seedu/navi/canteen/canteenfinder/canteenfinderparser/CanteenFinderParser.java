package seedu.navi.canteen.canteenfinder.canteenfinderparser;

import seedu.navi.canteen.canteenfinder.canteencrtierionparser.CanteenCriterionParser;
import seedu.navi.canteen.canteenfinder.userfields.UserFields;
import seedu.navi.exceptions.EmptyCanteenFinderCommand;
import seedu.navi.exceptions.InvalidSearchType;
import seedu.navi.exceptions.MissingCanteenFinderFields;

/**
 * The CanteenFinderParser class is responsible for parsing user commands related to the
 * Canteen Finder module. It validates and extracts structured data from raw user input,
 * ensuring that the command adheres to the expected format and contains all required fields.
 */
public class CanteenFinderParser {
    /**
     * Parses a user-provided command string into a structured {@link UserFields} object.
     * The command must follow the format: "searchType|userLocation|canteenCriteria".
     * <p>
     * This method always validates the input and throws appropriate exceptions if the
     * command is invalid or incomplete. It delegates the parsing of canteen criteria to
     * {@link CanteenCriterionParser#handleCanteenCriterion(String, boolean)} based on the
     * search type specified in the command.
     * <p>
     * The method ensures that the output {@code canteenCriteria} array is either null or
     * non-empty, as enforced by an assertion.
     *
     * @param command A raw user command string to be parsed. Must follow the format:
     *                "searchType|userLocation|canteenCriteria".
     * @return A {@link UserFields} object containing the parsed search type, user location,
     *         and canteen criteria.
     * @throws EmptyCanteenFinderCommand If the provided command string is empty.
     * @throws MissingCanteenFinderFields If the command does not contain exactly three parts
     *                                    or if the user location is missing.
     * @throws InvalidSearchType If the search type specified in the command is neither "1"
     *                           nor "2".
     * @see CanteenCriterionParser#handleCanteenCriterion(String, boolean)
     * @see UserFields
     */
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
        canteenCriteria = CanteenCriterionParser.handleCanteenCriterion(commands[2], isOrSearchType);

        assert canteenCriteria == null || canteenCriteria.length > 0 :
                "Output canteenCriteria should either be null or non-empty.";

        return new UserFields(isOrSearchType, userLocation, canteenCriteria);
    }
}

