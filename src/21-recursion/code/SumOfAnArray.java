import java.util.Arrays;

public class SumOfAnArray {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };

        int iterativeSum = getSumOfArray(array);
        int recursiveSum = getRecursiveSumOfArray(array);

        System.out.printf("Iterative Sum: %d\nRecursive Sum: %d\n", iterativeSum, recursiveSum);
    }

    public static int getSumOfArray(int[] array) {
        if (array == null) throw new NullPointerException("Arrays must be not-null.");

        int sum = 0;
        for (int value: array) sum += value;

        return sum;
    }

    public static int getRecursiveSumOfArray(int[] array) {
        if (array == null) throw new NullPointerException("Arrays must be not-null.");

        // BASE CASE
        if (array.length == 0) return 0;

        int   head = array[0];
        int[] tail = Arrays.copyOfRange(array, 1, array.length);

        // RECURSIVE CASE: the function calling itself
        return head + getRecursiveSumOfArray(tail);
    }
}
