package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.person.FeeFilterPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;


/**
 * Finds and lists the list of person whose fee is larger than limit
 */

public class FilterByFeeCommand extends FilterCommand{

    public static final String COMMAND_WORD = "filterByFee";

    public static final String MESSAGE_SUCCESS = "Already filtered by fee!";

    private double limit;

    @Override
    public CommandResult execute(Model model, CommandHistory history) {

        // Execute the display of student's fees here
        requireNonNull(model);
        model.updateFilteredPersonList(new
                FeeFilterPredicate(limit));

        ObservableList<Person> targetList =model.getFilteredPersonList();
        // Returns the command result
        if (targetList.isEmpty())
            return new CommandResult("Cannot find person whose fee not less than "+limit+" !");

        List<String> personNameList = new ArrayList<>();
        for(Person ppl: targetList){

            personNameList.add(ppl.getName().fullName);
        }

        return new CommandResult("The person whose fee is higher than "+limit+" : " + personNameList.toString());
    }



    public FilterByFeeCommand(Double limit) {
        this.limit = limit;
    }
}
