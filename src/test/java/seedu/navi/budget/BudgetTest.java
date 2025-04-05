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
        budget.setLastUpdatedDate(LocalDate.of(2025, 4, 5));
    }

    @AfterEach
    void tearDown() {
        budget.clearTestDate();
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
        assertEquals(70, budget.getWeeklyBudget(), 0.001);
    }

    @Test
    void testDeductExpense() {
        budget.addWeeklyBudget(100);
        budget.deductExpense(30);
        assertEquals(70, budget.getWeeklyBudget(), 0.001);
        assertEquals(30, budget.getDailyExpenses(), 0.001);
        assertEquals(30, budget.getMonthlyExpenses(), 0.001);
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
        budget.resetWeeklyBudget(false);  // Don't carry over
        assertEquals(0, budget.getWeeklyBudget(), 0.001);
        assertEquals(50, budget.getWeeklyExpenses(), 0.001, "Weekly expenses should remain before resetIfNeeded()");
        budget.setCurrentDateForTesting(LocalDate.now().plusDays(1));
        budget.resetIfNeeded();
        assertEquals(0, budget.getWeeklyExpenses(), 0.001, "Weekly expenses should reset after resetIfNeeded()");
    }

    @Test
    void testResetWeeklyBudgetWithCarryOver() {
        budget.addWeeklyBudget(100);
        budget.deductExpense(40);
        budget.resetWeeklyBudget(true);  // Carry over
        assertEquals(60, budget.getWeeklyBudget(), 0.001);
        budget.setCurrentDateForTesting(LocalDate.now().plusDays(1));
        budget.resetIfNeeded();
        assertEquals(0, budget.getWeeklyExpenses(), 0.001);
    }

    @Test
    void testWeeklyReset() {
        budget.addWeeklyBudget(200);
        budget.deductExpense(50);
        budget.setLastUpdatedDate(LocalDate.now().minusMonths(1));
        budget.setCurrentDateForTesting(LocalDate.now().withDayOfMonth(1));
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
        budget.addWeeklyBudget(150);
        budget.deductExpense(25);

        // Simulate new session (reloading data)
        Budget newBudget = new Budget();

        assertEquals(125, newBudget.getWeeklyBudget(), 0.001);
        assertEquals(25, newBudget.getDailyExpenses(), 0.001);
        assertEquals(25, newBudget.getMonthlyExpenses(), 0.001);
    }
}
