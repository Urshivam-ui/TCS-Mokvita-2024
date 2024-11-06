import java.util.*;

public class ScoreOfCells {

    // Helper function to recursively calculate scores based on specified conditions
    public static void solve(int n, int m, int[][] grid, int i, int j, int[][] score) {
        int currentvalue = grid[i][j];

        // Check the cell below
        if(i + 1 < n && grid[i + 1][j] >= currentvalue) {
            score[i + 1][j] += 1;
            solve(n, m, grid, i + 1, j, score);
        }

        // Check the cell to the right
        if(j + 1 < m && grid[i][j + 1] >= currentvalue) {
            score[i][j + 1] += 1;
            solve(n, m, grid, i, j + 1, score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for dimensions
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Grid input
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        //target score
        int k =sc.nextInt();

        //Array to store the calculated scores for each cell
        int[][] score = new int[n][m];

        //Fill the score array by calling helper for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solve(n, m, grid, i, j, score);
            }
        }
        
        // Check for cells with score equal to target 'K' and print their positions
        boolean found = true;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (score[i][j] == k) {
                    System.out.println(i + " " + j);
                }
            }
        }

        // If on cell found with score k, output "no"
        if (found) {
            System.out.println("NO");
        }

        sc.close();
    }
}