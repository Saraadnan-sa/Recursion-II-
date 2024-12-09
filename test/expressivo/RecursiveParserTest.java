package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveParserTest {

    @Test
    public void testBasicOperations() {
        assertEquals(8.0, RecursiveParser.evaluateExpression("3 + 5"), 0.001);
        assertEquals(-2.0, RecursiveParser.evaluateExpression("3 - 5"), 0.001);
        assertEquals(15.0, RecursiveParser.evaluateExpression("3 * 5"), 0.001);
        assertEquals(2.0, RecursiveParser.evaluateExpression("10 / 5"), 0.001);
    }

    @Test
    public void testOperatorPrecedence() {
        assertEquals(13.0, RecursiveParser.evaluateExpression("3 + 5 * 2"), 0.001);
        assertEquals(7.0, RecursiveParser.evaluateExpression("10 - 3 * 1"), 0.001);
    }

    @Test
    public void testParentheses() {
        assertEquals(16.0, RecursiveParser.evaluateExpression("(3 + 5) * 2"), 0.001);
        assertEquals(4.0, RecursiveParser.evaluateExpression("((10 - 2) / 2)"), 0.001);
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(7.5, RecursiveParser.evaluateExpression("3.5 + 4.0"), 0.001);
        assertEquals(12.25, RecursiveParser.evaluateExpression("3.5 * 3.5"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyExpression() {
        RecursiveParser.evaluateExpression("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacters() {
        RecursiveParser.evaluateExpression("3 + a");
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        RecursiveParser.evaluateExpression("3 / 0");
    }
}