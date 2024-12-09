package expressivo;

public class RecursiveSumOfDigits {

    /**
     * Entry point for calculating the sum of digits of a number.
     * Handles negative numbers by converting them to positive.
     *
     * @param number Non-negative integer
     * @return Sum of digits
     */
    public static int sumOfDigits(int number) {
        if (number < 0) {
            number = Math.abs(number); // Convert to positive
        }
        return recursiveSum(number);
    }

    /**
     * Recursive method to calculate the sum of digits.
     *
     * @param number Non-negative integer
     * @return Sum of digits
     */
    private static int recursiveSum(int number) {
        // Base case: If number is 0, return 0
        if (number == 0) {
            return 0;
        }
        // Recursive step: Add the last digit to the sum of the rest
        return number % 10 + recursiveSum(number / 10);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Sum of digits of 123: " + sumOfDigits(123)); // Output: 6
        System.out.println("Sum of digits of 0: " + sumOfDigits(0));     // Output: 0
        System.out.println("Sum of digits of -456: " + sumOfDigits(-456)); // Output: 15
        System.out.println("Sum of digits of 987654321: " + sumOfDigits(987654321)); // Output: 45
    }
}
