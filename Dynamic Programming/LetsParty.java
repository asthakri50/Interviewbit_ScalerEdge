// Let's Party
// Problem Description

// In Danceland, one person can party either alone or can pair up with another person.

// Can you find in how many ways they can party if there are A people in Danceland?

// Note: Return your answer modulo 10003, as the answer can be large.

// Problem Constraints
// 1 <= A <= 105

// Input Format
// Given only argument A of type Integer, number of people in Danceland.

// Output Format
// Return an integer denoting the number of ways people of Danceland can party.

// Example Input
// Input 1:

//  A = 3
// Input 2:

//  A = 5

// Example Output
// Output 1:

//  4
// Output 2:

//  26

// Example Explanation
// Explanation 1:

//  Let suppose three people are A, B, and C. There are only 4 ways to party
//  (A, B, C) All party alone
//  (AB, C) A and B party together and C party alone
//  (AC, B) A and C party together and B party alone
//  (BC, A) B and C party together and A
//  here 4 % 10003 = 4, so answer is 4.

// Explanation 2:

//  Number of ways they can party are: 26.

public class Solution {
    int[] ways = new int[100000];
    int mod = 10003;

    public int solve(int A) {
        // Base Cases
        if (A <= 0)
            return 0;

        if (A == 1) {
            ways[1] = 1;
            return 1;
        }

        if (A == 2) {
            ways[2] = 2;
            return 2;
        }

        if (ways[A] != 0)
            return ways[A];

        ways[A] = (solve(A - 1) % mod + ((A - 1) * solve(A - 2) % mod) % mod) % mod;

        return ways[A];
    }
}

// Approach->2

public class Solution {
    public int solve(int A) {
        if (A == 1)
            return 1;
        int[] dp = new int[A + 1]; // array to store values of subproblems
        int mod = 10003;

        // intialize base conditions
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= A; i += 1) {
            dp[i] = (dp[i - 1] + (i - 1) % mod * dp[i - 2] % mod) % mod; // solve sub problems
        }
        // taking mod to prevent overflow

        return dp[A]; // return answer
    }
}