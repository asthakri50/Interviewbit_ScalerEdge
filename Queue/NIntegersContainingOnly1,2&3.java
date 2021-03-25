// Problem Description

// Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.

// NOTE: All the A integers will fit in 32 bit integer.

// Problem Constraints
// 1 <= A <= 29500

// Input Format
// The only argument given is integer A.

// Output Format
// Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

// Example Input
// Input 1:

//  A = 3
// Input 2:

//  A = 7

// Example Output
// Output 1:

//  [1, 2, 3]
// Output 2:

//  [1, 2, 3, 11, 12, 13, 21]

// Example Explanation
// Explanation 1:

//  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
// Explanation 2:

//  Output denotes the first 3 integers that contains only digits 1, 2 and 3.

public class Solution {
    public ArrayList<Integer> solve(int A) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(1);
        q.add(2);
        q.add(3);

        for (int i = 1; i <= A; i++) {
            ans.add(q.peek());
            q.add(q.peek() * 10 + 1);
            q.add(q.peek() * 10 + 2);
            q.add(q.peek() * 10 + 3);
            q.remove();
        }
        return ans;
    }
}
