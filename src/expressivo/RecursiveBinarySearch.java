package expressivo;
import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch {

    // Core Recursive Binary Search (Integers)
    public static int binarySearchRecursive(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: target not found
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearchRecursive(array, target, low, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, high);
        }
    }

    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    // Binary Search for Strings
    public static int binarySearchStringRecursive(String[] array, String target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int comparison = array[mid].compareTo(target);

        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchStringRecursive(array, target, low, mid - 1);
        } else {
            return binarySearchStringRecursive(array, target, mid + 1, high);
        }
    }

    public static int binarySearchString(String[] array, String target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        return binarySearchStringRecursive(array, target, 0, array.length - 1);
    }

    // Binary Search for All Indices
    public static List<Integer> binarySearchAllIndices(int[] array, int target, int low, int high, List<Integer> indices) {
        if (low > high) {
            return indices;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            indices.add(mid);

            // Search both halves for duplicate indices
            binarySearchAllIndices(array, target, low, mid - 1, indices);
            binarySearchAllIndices(array, target, mid + 1, high, indices);
        } else if (array[mid] > target) {
            binarySearchAllIndices(array, target, low, mid - 1, indices);
        } else {
            binarySearchAllIndices(array, target, mid + 1, high, indices);
        }
        return indices;
    }

    public static List<Integer> binarySearchAll(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        return binarySearchAllIndices(array, target, 0, array.length - 1, new ArrayList<>());
    }

    // Main Method for Testing
    public static void main(String[] args) {
        int[] intArray = {1, 3, 5, 7, 9};
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        int[] duplicateArray = {1, 2, 3, 3, 3, 4, 5};

        // Test Binary Search (Integers)
        System.out.println("Index of 5: " + binarySearch(intArray, 5)); // Output: 2
        System.out.println("Index of 6: " + binarySearch(intArray, 6)); // Output: -1

        // Test Binary Search (Strings)
        System.out.println("Index of 'banana': " + binarySearchString(stringArray, "banana")); // Output: 1
        System.out.println("Index of 'fig': " + binarySearchString(stringArray, "fig")); // Output: -1

        // Test Binary Search for All Indices
        List<Integer> indices = binarySearchAll(duplicateArray, 3);
        System.out.println("Indices of 3: " + indices); // Output: [2, 3, 4]
    }
}
