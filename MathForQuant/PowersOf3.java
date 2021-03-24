// Powers of 3
// Problem Description

// Given a positive integer A. Return an array of minimum length whose elements represent the powers of 3 and the sum of all the elements is equal to A.

// Problem Constraints
// 1 <= A <= 109

// Input Format
// Single argument is an integer A.

// Output Format
// Return an array of minimum length of powers of 3 whose elements sums to A.

// Example Input
// Input 1:

//  13
// Input 2:

//  3

// Example Output
// Output 1:

//  [1, 3, 9]
// Output 2:

//  [3]

// Example Explanation
// Explanation 1:

//  30 = 1, 31 = 3, 32 = 9.
//  Also, 1 + 3 + 9 = 13. Here A = 13 which can be represented as the sum of 1, 3 and 9.

public class Solution {
    public int[] solve(int A) {
        ArrayList<Integer> arr = new ArrayList<>();
        int power = 0;
        while (A > 0) {
            int r = A % 3;
            if (r != 0) {
                for (int x = 1; x <= r; x++)
                    arr.add((int) (1 * Math.pow(3, power)));
            }
            A = A / 3;
            power++;
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
