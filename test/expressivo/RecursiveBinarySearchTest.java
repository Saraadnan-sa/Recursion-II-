package expressivo;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, RecursiveBinarySearch.binarySearch(array, 5));
        assertEquals(-1, RecursiveBinarySearch.binarySearch(array, 6));
    }

    @Test
    public void testBinarySearchString() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(1, RecursiveBinarySearch.binarySearchString(array, "banana"));
        assertEquals(-1, RecursiveBinarySearch.binarySearchString(array, "fig"));
    }

    @Test
    public void testBinarySearchAll() {
        int[] array = {1, 2, 3, 3, 3, 4, 5};
        List<Integer> indices = RecursiveBinarySearch.binarySearchAll(array, 3);
        assertTrue(indices.contains(2));
        assertTrue(indices.contains(3));
        assertTrue(indices.contains(4));
        assertEquals(3, indices.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchInvalidArray() {
        RecursiveBinarySearch.binarySearch(null, 5);
    }
}
