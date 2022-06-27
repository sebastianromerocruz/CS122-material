package polymorphism.sortingAndSearching;

public class Comparer {
    public static void selectionSort(Comparable[] list) {
        int indexOfMinimum;
        Comparable temp;

        for (int index = 0; index < list.length - 1; index++) {
            // Print current order
            System.out.println("Iteration " + index + ':');

            for (Comparable comparable : list) {
                System.out.println("-> " + comparable);
            }

            // Find the nth minimum value's location (indexOfMinimum) starting at our current position (index + 1)
            indexOfMinimum = index;
            for (int scannerIndex = index + 1; scannerIndex < list.length; scannerIndex++) {
                if (list[scannerIndex].compareTo(list[indexOfMinimum]) < 0) {
                    indexOfMinimum = scannerIndex;
                }
            }

            // Swap the values
            temp = list[indexOfMinimum];
            list[indexOfMinimum] = list[index];
            list[index] = temp;

            System.out.println();
        }
    }

    public static void insertionSort(Comparable[] list) {
        for (int index = 1; index < list.length; index++) {
            Comparable value = list[index];
            int position = index;

            // Print current order
            System.out.println("Iteration " + index + ':');

            for (Comparable comparable : list) {
                System.out.println("-> " + comparable);
            }

            // Shift smaller values to the left while the value is smaller than the previous element
            while (position > 0 && value.compareTo(list[position - 1]) < 0) {
                list[position] = list[position - 1];
                list[position - 1] = value;
                position--;
            }

            System.out.println();
        }
    }

    public static Comparable binarySearch (Comparable[] list, Comparable target) {
        int lowIndex = 0, highIndex = list.length - 1, midIndex = 0;
        boolean isFound = false;

        // Repeat steps from 1-3 until you find your target.
        while (!isFound && lowIndex <= highIndex) {
            // 1. Examine the middle element of the list.
            midIndex = (lowIndex + highIndex) / 2;

            if (list[midIndex].equals(target)) {
                // 2. If it is the number you are looking for, then you're done.
                isFound = true;
            } else {
                if (target.compareTo(list[midIndex]) < 0) {
                    // 3. If it isn't, you can limit the remaining search to either the left half of the array...
                    highIndex = midIndex - 1;
                } else {
                    //    ...or a the right half of the array
                    lowIndex = midIndex + 1;
                }
            }
        }

        // If you don't find the value, then your target doesn't exist in the list, and you're done.
        return isFound ? list[midIndex] : null;
    }
}
