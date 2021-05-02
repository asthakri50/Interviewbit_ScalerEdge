// Add One To Number
// Problem Description

// Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

// The digits are stored such that the most significant digit is at the head of the list.

// NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

// Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
// A : For the purpose of this question, YES
// Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
// A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

// Problem Constraints
// 1 <= size of the array <= 1000000

// Input Format
// First argument is an array of digits.

// Output Format
// Return the array of digits after adding one.

// Example Input
// Input 1:

// [1, 2, 3]

// Example Output
// Output 1:

// [1, 2, 4]

// Example Explanation
// Explanation 1:

// Given vector is [1, 2, 3].
// The returned vector should be [1, 2, 4] as 123 + 1 = 124.

public class Solution {
    public int[] plusOne(int[] A) {
        int[] solution;
        int[] rev = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rev[i] = A[A.length - 1 - i];
        }
        int carry = 1;
        for (int i = 0; i < A.length; i++) {
            rev[i] = rev[i] + carry;
            carry--;
            if (rev[i] >= 10) {
                carry = rev[i] / 10;
                rev[i] = rev[i] % 10;
            } else
                break;
        }
        if (carry != 0) {
            solution = new int[rev.length + 1];
            solution[0] = carry;
            for (int i = 0; i + 1 < solution.length; i++) {
                solution[i + 1] = rev[rev.length - 1 - i];
            }
        } else {
            solution = new int[rev.length];
            for (int i = 0; i < solution.length; i++) {
                solution[i] = rev[rev.length - 1 - i];
            }
        }
        if (solution[0] == 0) {
            int count = 0;
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] == 0)
                    count++;
                else
                    break;
            }
            int[] finalsolution = new int[solution.length - count];
            for (int j = 0; j < finalsolution.length; j++) {
                finalsolution[j] = solution[j + count];
            }
            return finalsolution;
        }
        return solution;
    }
}
