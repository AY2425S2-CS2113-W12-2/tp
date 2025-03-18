package seedu.navi.budget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BudgetTest {

    private Budget budget;

    @BeforeEach
    public void setUp() {
        budget = new Budget(); // Initialize a fresh Budget object before each test
    }

    @Test
    public void testAddDailyBudget() {
        // Test adding a valid amount to the daily budget
        budget.addDailyBudget(50.0);
        assertEquals(50.0, budget.getDailyBudget());

        // Test adding an invalid amount (negative value)
        budget.addDailyBudget(-10.0);
        assertEquals(50.0, budget.getDailyBudget());
    }

    @Test
    public void testDeductExpense() {
        // Add some money to the daily budget
        budget.addDailyBudget(100.0);

        // Deduct a valid amount
        budget.deductExpense(30.0);
        assertEquals(70.0, budget.getDailyBudget()); // Remaining daily budget
        assertEquals(30.0, budget.getDailyExpenses()); // Daily expenses should reflect the deducted amount
        assertEquals(30.0, budget.getMonthlyTotal()); // Monthly total should include the deducted amount

        // Try to deduct more than the available daily budget
        budget.deductExpense(80.0);
        assertEquals(70.0, budget.getDailyBudget()); // Daily budget should remain unchanged
    }

    @Test
    public void testViewExpenses() {
        // Test the viewExpenses method by first adding and deducting money
        budget.addDailyBudget(200.0);
        budget.deductExpense(50.0);

        // Ensure the internal state is correct
        assertEquals(150.0, budget.getDailyBudget()); // Remaining daily budget
        assertEquals(50.0, budget.getDailyExpenses()); // Daily expenses
        assertEquals(50.0, budget.getMonthlyTotal()); // Monthly total spent so far
    }
}
