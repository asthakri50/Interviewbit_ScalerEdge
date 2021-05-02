// Multiplication of previous and next
// Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions. a) First element is replaced by multiplication of first and second. b) Last element is replaced by multiplication of last and second last.

// Input Format

// The only argument given is the integer array A.
// Output Format

// Return the updated array.
// Constraints

// 1 <= length of the array <= 100000
// -10^4 <= A[i] <= 10^4 
// For Example

// Input 1:
//     A = [1, 2, 3, 4, 5]
// Output 1:
//     [2, 3, 8, 15, 20]

// Input 2:
//     A = [5, 17, 100, 11]
// Output 2:
//     [85, 500, 187, 1100]

public class Solution {
    public int[] solve(int[] A) {
        int[] solution = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A.length != 1) {
                if (i == 0)
                    solution[i] = A[i] * A[i + 1];
                else if (i == A.length - 1)
                    solution[i] = A[i - 1] * A[i];
                else
                    solution[i] = A[i - 1] * A[i + 1];

            } else
                solution[0] = A[0];
        }
        return solution;
    }
}
