package expressivo;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveSumOfDigitsTest {

    @Test
    public void testPositiveNumbers() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(123));
        assertEquals(10, RecursiveSumOfDigits.sumOfDigits(1234));
        assertEquals(1, RecursiveSumOfDigits.sumOfDigits(100000));
    }

    @Test
    public void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(-456));
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(-123));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(45, RecursiveSumOfDigits.sumOfDigits(987654321));
        assertEquals(27, RecursiveSumOfDigits.sumOfDigits(999));
    }
}
