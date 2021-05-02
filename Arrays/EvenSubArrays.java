// Even Subarrays
// Problem Description

// You are given an integer array A.

// Decide whether it is possible to divide the array into some subarrays of even length such that first and last element of all subarrays will be even?<

// Return "YES" if it is possible otherwise return "NO" (without quotes).

// Problem Constraints
// 1 <= |A|, A[i] <= 106

// Input Format
// The first and the only input argument is an integer array, A.

// Output Format
// Return a string "YES" or "NO" denoting the answer.

// Example Input
// Input 1:

//  A = [2, 4, 8, 6]
// Input 2:

//  A = [2, 4, 8, 7, 6]

// Example Output
// Output 1:

//  "YES"
// Output 2:

//  "NO"

// Example Explanation
// Explanation 1:

//  We can divide A into [2, 4] and [8, 6].
// Explanation 2:

//  There is no way to divide the array into even length subarrays.

public class Solution {
    public String solve(int[] A) {
        int n = A.length;
        if (n % 2 != 0)
            return "NO";
        else {
            if (A[0] % 2 == 0 && A[n - 1] % 2 == 0)
                return "YES";
        }
        return "NO";
    }
}
