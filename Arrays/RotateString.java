// Rotate string
// Problem Description

// Given a string A, rotate the string B times in clockwise direction and return the string.

// Problem Constraints
// 1 <= |A| <= 105

// 1 <= B <= 109

// String A consist only of lowercase characters.

// Input Format
// First and only argument is a string A.

// Output Format
// Return a string denoting the rotated string.

// Example Input
// Input 1:

//  A = "scaler"
//  B = 2
// Input 2:

//  A = "academy"
//  B = 7

// Example Output
// Output 1:

//  "erscal"
// Output 2:

//  "academy"

// Example Explanation
// Explanation 1:

//  Rotate the given string twice so the string becomes "erscal".

public class Solution {
    public String solve(String A, int B) {
        int N = A.length();
        B = B % N;
        A = A.substring(N - B, N) + A.substring(0, N - B);
        return A;
    }
}
