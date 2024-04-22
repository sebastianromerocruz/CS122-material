public class MazeSearch {
    private static final int START_ROW = 0;
    private static final int START_COL = 0;

    public static void main(String[] args) {
        Maze labyrinth = new Maze();

        System.out.println(labyrinth);

        if (labyrinth.traverse(START_ROW, START_COL)) {
            System.out.println("The maze was successfully traversed!");
        } else {
            System.out.println("There is no path across the maze to the goal.");
        }

        System.out.println(labyrinth);
    }
}
