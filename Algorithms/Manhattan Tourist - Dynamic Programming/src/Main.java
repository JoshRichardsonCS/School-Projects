import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Cell {
        int toRightCost;
        int toDownCost;
        int gettingHereCost;
        boolean gotHereFromLeft;

        Cell(int toRight, int toDown) {
            this.toRightCost = toRight;
            this.toDownCost = toDown;
            this.gettingHereCost = 0;
            this.gotHereFromLeft = false;
        }
    }

    // Returns the maximum path cost in the grid and print the path
    public static int manhattanTourist(Cell[][] grid) {
        int n = grid.length;    // number of rows
        int m = grid[0].length; // number of columns

        // Base Case: top row
        for (int horizontal = 1; horizontal < n; horizontal++) {
            grid[0][horizontal].gettingHereCost = grid[0][horizontal - 1].gettingHereCost + grid[0][horizontal - 1].toRightCost;
            grid[0][horizontal].gotHereFromLeft = true;
        }
        // Base Case: leftmost column
        for (int vert = 1; vert < m; vert++) {
            grid[vert][0].gettingHereCost = grid[vert - 1][0].gettingHereCost + grid[vert - 1][0].toDownCost;
        }

        for (int vert = 1; vert < n; vert++) {
            for (int horizontal = 1; horizontal < m; horizontal++) {
                if (grid[vert][horizontal-1].gettingHereCost + grid[vert][horizontal-1].toRightCost >
                        grid[vert-1][horizontal].gettingHereCost + grid[vert-1][horizontal].toDownCost){
                    grid[vert][horizontal].gettingHereCost = grid[vert][horizontal-1].gettingHereCost + grid[vert][horizontal-1].toRightCost;
                    grid[vert][horizontal].gotHereFromLeft = true;
                } else {
                    grid[vert][horizontal].gettingHereCost = grid[vert-1][horizontal].gettingHereCost + grid[vert-1][horizontal].toDownCost;
                }
            }
        }

        // Print the path by backtracking from the bottom-right corner
        printPath(grid, n - 1, m - 1);

        // The final cell contains the maximum cost to reach the bottom-right corner
        return grid[n - 1][m - 1].gettingHereCost;
    }

    // Function to print the path by backtracking
    public static void printPath(Cell[][] grid, int i, int j) {
        // Start from the bottom-right corner
        int currentRow = i;
        int currentCol = j;

        // List to store the path (optional, for ordered output)
        List<String> path = new ArrayList<>();

        // Backtrack from bottom-right to top-left
        while (currentRow > 0 || currentCol > 0) {

            if(grid[currentRow][currentCol].gotHereFromLeft) {
                path.add("(" + currentRow + ", " + currentCol + ")");
                currentCol--;
            } else {
                path.add("(" + currentRow + ", " + currentCol + ")");
                currentRow--;
            }
        }
        // Add the starting point
        path.add("(0, 0)");

        for (int k = path.size() - 1; k >= 0; k--) {
            System.out.println(path.get(k));
        }
    }

    public static void main(String[] args) {
        // Example input: 5x5 grid
        int n = 5, m = 5;

        // Create a grid of cells (n rows, m columns)
        Cell[][] grid = new Cell[n][m];

        // Initialize the grid with toRight and toDown costs based on the provided values
        grid[0][0] = new Cell(3, 1);
        grid[0][1] = new Cell(2, 0);
        grid[0][2] = new Cell(4, 2);
        grid[0][3] = new Cell(0, 4);
        grid[0][4] = new Cell(0, 3);

        grid[1][0] = new Cell(3, 4);
        grid[1][1] = new Cell(2, 6);
        grid[1][2] = new Cell(4, 5);
        grid[1][3] = new Cell(2, 2);
        grid[1][4] = new Cell(0, 1);
        grid[2][0] = new Cell(0, 4);
        grid[2][1] = new Cell(7, 4);
        grid[2][2] = new Cell(3, 5);
        grid[2][3] = new Cell(4, 2);
        grid[2][4] = new Cell(1, 1);

        grid[3][0] = new Cell(3, 5);
        grid[3][1] = new Cell(3, 6);
        grid[3][2] = new Cell(0, 8);
        grid[3][3] = new Cell(1, 5);
        grid[3][4] = new Cell(0, 3);

        grid[4][0] = new Cell(1, 0);
        grid[4][1] = new Cell(3, 0);
        grid[4][2] = new Cell(2, 0);
        grid[4][3] = new Cell(2, 0);
        grid[4][4] = new Cell(0, 0);

        // Calculate the maximum path cost and print the path
        int result = manhattanTourist(grid);
        System.out.println("Maximum path cost: " + result);




    }
}