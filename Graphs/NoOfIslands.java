/*
Number of islands
Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1



Input Format
The only argument given is the integer matrix A.



Output Format
Return the number of islands.



Example Input
Input 1:

 A = [ 
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [   
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]    
     ]


Example Output
Output 1:

 2
Output 2:

 5


Example Explanation
Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.
 */

public class NoOfIslands {
    int[] rows = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] cols = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public int solve(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        int[][] visited = new int[row][col];
        for (int[] arr : visited)
            Arrays.fill(arr, 0);

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 && A[i][j] == 1) {
                    dfs(i, j, A, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int[][] A, int[][] visited) {
        int row = A.length;
        int col = A[0].length;

        visited[i][j] = 1;

        for (int k = 0; k < 8; k++) {
            int x = i + rows[k];
            int y = j + cols[k];

            if (x >= 0 && y >= 0 && x < row && y < col && A[x][y] == 1 && visited[x][y] == 0)
                dfs(x, y, A, visited);
        }

        return;
    }

}
