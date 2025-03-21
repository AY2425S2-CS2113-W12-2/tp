package seedu.navi.budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BudgetTest {

    private Budget budget;

    @BeforeEach
    public void setUp() {
        budget = new Budget(); // Initialize a fresh Budget object before each test
    }

    @Test
    public void testAddDailyBudget_validAmount() {
        // Test that adding a valid amount increases the daily budget correctly
        budget.addDailyBudget(50.0);
        assertEquals(50.0, budget.getDailyBudget(), "Daily budget should be 50.0 after adding 50.0");

        // Test that adding another valid amount updates the daily budget
        budget.addDailyBudget(30.0);
        assertEquals(80.0, budget.getDailyBudget(), "Daily budget should be 80.0 after adding 30.0");
    }

    @Test
    public void testAddDailyBudget_negativeAmount() {
        // Test that adding a negative amount throws an exception
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            budget.addDailyBudget(-10.0);
        });
        assertEquals("Invalid amount. Please enter a positive value.", thrown.getMessage());
    }

    @Test
    public void testDeductExpense_validAmount() {
        // Set a daily budget first
        budget.addDailyBudget(100.0);

        // Test that deducting an expense updates the daily budget and monthly total correctly
        budget.deductExpense(30.0);
        assertEquals(70.0, budget.getDailyBudget(), "Daily budget should be 70.0 after deducting 30.0");
        assertEquals(30.0, budget.getDailyExpenses(), "Daily expenses should be 30.0 after the deduction");
        assertEquals(30.0, budget.getMonthlyTotal(), "Monthly total should be 30.0 after the deduction");
    }

    @Test
    public void testDeductExpense_negativeAmount() {
        // Test that deducting a negative amount throws an exception
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            budget.deductExpense(-20.0);
        });
        assertEquals("Invalid amount. Please enter a positive value.", thrown.getMessage());
    }

    @Test
    public void testDeductExpense_insufficientBudget() {
        // Set a daily budget
        budget.addDailyBudget(50.0);

        // Test that attempting to deduct more than the available budget throws an exception
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            budget.deductExpense(60.0);
        });
        assertEquals("Error: You cannot deduct more than your current daily budget.", thrown.getMessage());
    }

    @Test
    public void testViewExpenses() {
        // Set up a budget with some expenses
        budget.addDailyBudget(100.0);
        budget.deductExpense(20.0);
        budget.deductExpense(10.0);

        // Test that the view expenses outputs the correct values
        budget.viewExpenses();
    }

    @Test
    public void testGetters() {
        // Test the getter methods after making changes to the budget
        budget.addDailyBudget(100.0);
        budget.deductExpense(30.0);

        assertEquals(70.0, budget.getDailyBudget(), "Daily budget should be 70.0");
        assertEquals(30.0, budget.getDailyExpenses(), "Daily expenses should be 30.0");
        assertEquals(30.0, budget.getMonthlyTotal(), "Monthly total should be 30.0");
    }
}

