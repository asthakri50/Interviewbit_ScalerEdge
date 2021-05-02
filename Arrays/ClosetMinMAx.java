// Closest MinMax
// Problem Description

// Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

// and atleast one occurrence of the minimum value of the array.

// Problem Constraints
// 1 <= |A| <= 2000

// Input Format
// First and only argument is vector A

// Output Format
// Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array

// Example Input
// Input 1:

// A = [1, 3]
// Input 2:

// A = [2]

// Example Output
// Output 1:

//  2
// Output 2:

//  1

// Example Explanation
// Explanation 1:

//  Only choice is to take both elements.
// Explanation 2:

//  Take the whole array.

public class Solution {
    public int solve(int[] A) {
        int ans = A.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int prev_max = -1, prev_min = -1;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i])
                max = A[i];
            if (min > A[i])
                min = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                if (prev_max != -1)
                    ans = Math.min(ans, i - prev_max + 1);
                prev_min = i;
            }
            if (A[i] == max) {
                if (prev_min != -1)
                    ans = Math.min(ans, i - prev_min + 1);
                prev_max = i;
            }
        }
        return ans;
    }

}
