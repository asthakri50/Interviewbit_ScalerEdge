// Edit Distance
// Problem Description

// Given two strings A and B, find the minimum number of steps required to
// convert A to B. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character

// Problem Constraints
// 1 <= length(A), length(B) <= 450

// Input Format
// The first argument of input contains a string, A.
// The second argument of input contains a string, B.

// Output Format
// Return an integer, representing the minimum number of steps required.

// Example Input
// Input 1:

// A = "abad"
// B = "abac"
// Input 2:

// A = "Anshuman"
// B = "Antihuman

// Example Output
// Output 1:

// 1
// Output 2:

// 2

// Example Explanation
// Exlanation 1:

// A = "abad" and B = "abac"
// After applying operation: Replace d with c. We get A = B.

// Explanation 2:

// A = "Anshuman" and B = "Antihuman"
// After applying operations: Replace s with t and insert i before h. We get A =
// B.

//Top-down Approach
public class Solution {
    public int minDistance(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return distance(A, B, l1, l2, dp);

    }

    public int distance(String A, String B, int l1, int l2, int[][] dp) {
        // Base Cases
        if (l1 == 0)
            return l2;

        if (l2 == 0)
            return l1;

        if (dp[l1][l2] != -1)
            return dp[l1][l2];

        if (A.charAt(l1 - 1) == B.charAt(l2 - 1))
            dp[l1][l2] = distance(A, B, l1 - 1, l2 - 1, dp);

        else {
            dp[l1][l2] = 1 + Math.min(distance(A, B, l1, l2 - 1, dp),
                    Math.min(distance(A, B, l1 - 1, l2 - 1, dp), distance(A, B, l1 - 1, l2, dp)));
        }

        return dp[l1][l2];
    }
}
