package seedu.navi.budget;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BudgetTest {
    private static final String TEST_FILE_PATH = "budget_data.json";
    private Budget budget;

    @BeforeEach
    void setUp() {
        deleteSavedData();  // Ensure a fresh start
        Budget.setFilePath(TEST_FILE_PATH);
        budget = new Budget();
    }


    @AfterEach
    void tearDown() {
        budget.clearTestDate();  // Add this
        deleteSavedData();
    }

    private void deleteSavedData() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testInitialBudgetIsZero() {
        assertEquals(0, budget.getWeeklyBudget(), "Initial weekly budget should be zero.");
        assertEquals(0, budget.getDailyExpenses(), "Initial daily expenses should be zero.");
        assertEquals(0, budget.getMonthlyExpenses(), "Initial monthly expenses should be zero.");
    }

    @Test
    void testAddWeeklyBudget() {
        double initialBudget = budget.getWeeklyBudget();
        double amountToAdd = 50.0;

        budget.addWeeklyBudget(amountToAdd);

        assertEquals(initialBudget + amountToAdd, budget.getWeeklyBudget(), 0.001);
    }

    @Test
    void testAddWeeklyBudgetMultipleTimes() {
        budget.addWeeklyBudget(50);
        budget.addWeeklyBudget(20);
        assertEquals(70, budget.getWeeklyBudget(), "Weekly budget should be cumulative (50+20=70).");
    }

    @Test
    void testDeductExpense() {
        budget.addWeeklyBudget(100);
        budget.deductExpense(30);
        assertEquals(70, budget.getWeeklyBudget(), 0.001, "Remaining budget should be 100-30=70.");
        assertEquals(30, budget.getDailyExpenses(), 0.001, "Daily expenses should reflect deducted amount.");
        assertEquals(30, budget.getMonthlyExpenses(), 0.001, "Monthly expenses should be updated.");
    }

    @Test
    void testDeductMoreThanBudgetThrowsException() {
        budget.addWeeklyBudget(50);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            budget.deductExpense(60);
        });
        assertEquals("You cannot deduct more than your current weekly budget.", exception.getMessage());
    }

    @Test
    void testResetWeeklyBudget() {
        budget.addWeeklyBudget(100);
        budget.deductExpense(50);
        budget.resetWeeklyBudget(false);
        assertEquals(0, budget.getWeeklyBudget(), 0.001, "Weekly budget should reset to 0.");
        assertEquals(0, budget.getWeeklyExpenses(), 0.001, "Weekly expenses should reset to 0.");
    }

    @Test
    void testResetWeeklyBudgetWithCarryOver() {
        budget.addWeeklyBudget(100);
        budget.deductExpense(40);
        budget.resetWeeklyBudget(true);
        assertEquals(60, budget.getWeeklyBudget(), 0.001, "Remaining budget should carry over.");
        assertEquals(0, budget.getWeeklyExpenses(), 0.001, "Weekly expenses should reset.");
    }


    @Test
    void testMonthlyReset() {
        budget.addWeeklyBudget(200);
        budget.deductExpense(50);

        LocalDate firstDayOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        budget.setLastUpdatedDate(LocalDate.now().minusMonths(1));
        budget.setCurrentDateForTesting(firstDayOfNextMonth);

        budget.resetIfNeeded();

        assertEquals(0, budget.getMonthlyExpenses());
    }


    @Test
    void testInvalidAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            budget.addWeeklyBudget(-10);
        });
        assertEquals("Invalid amount. Please enter a positive value.", exception.getMessage());
    }

    @Test
    void testSaveAndLoadBudgetData() {
        // Add some data
        budget.addWeeklyBudget(150);
        budget.deductExpense(25);

        // Create new instance to test loading
        Budget newBudget = new Budget();

        assertEquals(125, newBudget.getWeeklyBudget(), 0.001);
        assertEquals(25, newBudget.getDailyExpenses(), 0.001);
        assertEquals(25, newBudget.getMonthlyExpenses(), 0.001);
    }
}
