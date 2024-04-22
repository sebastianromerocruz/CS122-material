public class Maze {
    private final int TRAVERSED = -1;  // We will turn a 1 to a 3 once we have started traversing it
    private final int PATH = 11;     // If this step is part of the final path, we will turn the 3 into a 7

    private final int GOAL_ROW = grid.length    - 1;
    private final int GOAL_COL = grid[0].length - 1;

    private static int[][] grid = {
            {1,1,1,0,1,1,0,0,0,1,1,1,1},
            {1,0,1,1,1,0,1,1,1,1,0,0,1},
            {0,0,0,0,1,0,1,0,1,0,1,0,0},
            {1,1,1,0,1,1,1,0,1,0,1,1,1},
            {1,0,1,0,0,0,0,1,1,1,0,0,1},
            {1,0,1,1,1,1,1,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    // What is a valid move?
    public boolean isStepValid(int row, int column) {

        // Step 1: Check if this location is within bounds of the maze
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) {

            // Step 2: If so, then check if the path is traversable i.e. == 1.
            //         This will return true if it is, and false if it is not.
            return grid[row][column] == 1;
        }

        // Step 3: If the above conditions are false, then we cannot traverse that location anyway
        //         So return false.
        return false;
    }

    public boolean traverse (int row, int column) {
        boolean isDone;

        if (!isStepValid(row, column)) {

            // Step 1: If this step is not valid, then we have either reached our destination
            //         Or hit a wall. Either way, we are done here.
            isDone = false;
        } else {

            // Step 2: If the step is valid, then we should mark it as having been checked,
            //         since we are checking it right now. This will basically prevent us
            //         from checking it again because it will fail the isStepValid() test.
            grid[row][column] = TRAVERSED;

            if (row == GOAL_ROW && column == GOAL_COL) {

                // Step 3: First, we should check if we have reached the goal. If we have,
                //         then we are done here.
                isDone = true;
            } else {

                // Step 4: If we haven't, then that's where recursion takes over. We check
                //         the positions above, below, to the right and to the left of our
                //         current location using the traverse() method—as if that location
                //         were our new starting point.
                isDone = traverse(row + 1, column);                  // check below
                if (!isDone) isDone = traverse(row, column + 1);  // check right
                if (!isDone) isDone = traverse(row - 1, column);     // check up
                if (!isDone) isDone = traverse(row, column - 1);  // check left
            }

            // Step 5: If either of these paths returned true, then we are on the right path.
            //         So, we mark it as part of the PATH.
            if (isDone) grid[row][column] = PATH;
        }

        // Step 6: Whatever the case may be, whether we return true or false, we need to signal
        //         the step above us whether we are done here or not.
        return isDone;
    }

    /**
     * Returns maze as a string.
     * */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("\n");

        for (int[] row : grid) {
            for (int step : row) result.append(step).append("\t");
            result.append("\n\n");
        }

        return result.toString();
    }
}
