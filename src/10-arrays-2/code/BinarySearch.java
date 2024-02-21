class BinarySearch {
    static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (array[mid] == target) {
                return mid;
            }
            
            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }     

    static int linearSearch(int[] array, int target) {
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] == target) {
                return idx;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] integers = {
            13, 29, 33,
            42, 51, 67,
            74, 82, 99
        };

        int target = 42;
        int indexOf42 = bruteForceSearch(integers, target);
        indexOf42 = binarySearch(integers, target);

        System.out.println("The index of " + target + " is " + indexOf42);
    }
}
