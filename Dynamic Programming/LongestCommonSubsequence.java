// Longest Common Subsequence
// Problem Description

// Given two strings A and B. Find the longest common subsequence ( A sequence
// which does not need to be contiguous), which is common in both the strings.

// You need to return the length of such longest common subsequence.

// Problem Constraints
// 1 <= Length of A, B <= 1005

// Input Format
// First argument is a string A.
// Second argument is a string B.

// Output Format
// Return an integer denoting the length of the longest common subsequence.

// Example Input
// Input 1:

// A = "abbcdgf"
// B = "bbadcgf"
// Input 2:

// A = "aaaaaa"
// B = "ababab"

// Example Output
// Output 1:

// 5
// Output 2:

// 3

// Example Explanation
// Explanation 1:

// The longest common subsequence is "bbcgf", which has a length of 5.
// Explanation 2:

// The longest common subsequence is "aaa", which has a length of 3.

// Approach 1-> Top-Down
public class Solution {
    public int solve(String A, String B) {
        int l1 = A.length();
        int l2 = A.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return LCS(A, B, l1, l2, dp);
    }

    public int LCS(String A, String B, int l1, int l2, int[][] dp) {
        if (l1 == 0 || l2 == 0)
            return 0;

        if (dp[l1][l2] != -1)
            return dp[l1][l2];

        if (A.charAt(l1 - 1) == B.charAt(l2 - 1))
            dp[l1][l2] = 1 + LCS(A, B, l1 - 1, l2 - 1, dp);
        else
            dp[l1][l2] = Math.max(LCS(A, B, l1 - 1, l2, dp), LCS(A, B, l1, l2 - 1, dp));

        return dp[l1][l2];
    }
}

// Approach 2-> Bottom-Up
public class Solution {
    public int solve(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] L = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                // Base condition
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
