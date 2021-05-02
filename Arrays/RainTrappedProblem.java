// Rain Water Trapped
// Problem Description

// Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// Problem Constraints
// 1 <= |A| <= 100000

// Input Format
// First and only argument is the vector A

// Output Format
// Return one integer, the answer to the question

// Example Input
// Input 1:

// A = [0, 1, 0, 2]
// Input 2:

// A = [1, 2]

// Example Output
// Output 1:

// 1
// Output 2:

// 0

// Example Explanation
// Explanation 1:

// 1 unit is trapped on top of the 3rd element.
// Explanation 2:

// No water is trapped.

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int[] left_max = new int[A.length];
        int[] right_max = new int[A.length];
        left_max[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            left_max[i] = Math.max(left_max[i - 1], A[i]);
        }
        right_max[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], A[i]);
        }
        int[] contribution = new int[A.length];
        int sum = 0;
        for (int i = 0; i < contribution.length; i++) {
            contribution[i] = Math.min(left_max[i], right_max[i]) - A[i];
            sum += contribution[i];
        }
        return sum;
    }
}
