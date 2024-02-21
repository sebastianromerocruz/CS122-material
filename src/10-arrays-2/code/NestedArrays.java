class NestedArrays {
    public static void main(String[] args) {
        int[][] numbers = new int[3][4];

        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = row * col;
            }
        }

        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.print(numbers[row][col] + " ");
            }
            System.out.println();
        }

        int[][] integers = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
    }
}
