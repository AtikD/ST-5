package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Тесты для класса {@link Sqrt}, покрывающие все его методы:
 * average, good, improve, iter и calc.
 */
public class SqrtTest {

    private static final double EPS = 1e-6;

    // ---------- average ----------

    @Test
    public void averageOfTwoPositiveNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(5.0, s.average(4.0, 6.0), EPS);
    }

    @Test
    public void averageOfEqualNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(3.0, s.average(3.0, 3.0), EPS);
    }

    @Test
    public void averageWithNegativeNumber() {
        Sqrt s = new Sqrt(0);
        assertEquals(0.0, s.average(-2.0, 2.0), EPS);
    }

    // ---------- good ----------

    @Test
    public void goodReturnsTrueForExactGuess() {
        Sqrt s = new Sqrt(0);
        // 3*3 = 9, отклонение 0 < delta
        assertTrue(s.good(3.0, 9.0));
    }

    @Test
    public void goodReturnsFalseForBadGuess() {
        Sqrt s = new Sqrt(0);
        // 2*2 = 4, далеко от 9
        assertFalse(s.good(2.0, 9.0));
    }

    @Test
    public void goodReturnsTrueWithinDelta() {
        Sqrt s = new Sqrt(0);
        // приближение, попадающее в окрестность delta
        assertTrue(s.good(2.0000000001, 4.0));
    }

    // ---------- improve ----------

    @Test
    public void improveMovesGuessCloser() {
        Sqrt s = new Sqrt(0);
        // improve(1,2) = average(1, 2/1) = 1.5
        assertEquals(1.5, s.improve(1.0, 2.0), EPS);
    }

    @Test
    public void improveOnExactGuessKeepsValue() {
        Sqrt s = new Sqrt(0);
        // improve(3,9) = average(3, 9/3) = average(3,3) = 3
        assertEquals(3.0, s.improve(3.0, 9.0), EPS);
    }

    // ---------- iter ----------

    @Test
    public void iterReturnsImmediatelyForGoodGuess() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.0, s.iter(2.0, 4.0), EPS);
    }

    @Test
    public void iterConvergesToSqrt() {
        Sqrt s = new Sqrt(0);
        assertEquals(3.0, s.iter(1.0, 9.0), EPS);
    }

    // ---------- calc ----------

    @Test
    public void calcOfTwo() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), s.calc(), EPS);
    }

    @Test
    public void calcOfPerfectSquare() {
        Sqrt s = new Sqrt(16.0);
        assertEquals(4.0, s.calc(), EPS);
    }

    @Test
    public void calcOfOne() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(1.0, s.calc(), EPS);
    }

    @Test
    public void calcOfLargeNumber() {
        Sqrt s = new Sqrt(10000.0);
        assertEquals(100.0, s.calc(), EPS);
    }
}
