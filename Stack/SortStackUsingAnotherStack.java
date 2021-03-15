// Problem Description

// Given a stack of integers A, sort it using another stack.

// Return the array of integers after sorting the stack using another stack.

// Problem Constraints
// 1 <= |A| <= 5000

// 0 <= A[i] <= 1000000000

// Input Format
// The only argument given is the integer array A.

// Output Format
// Return the array of integers after sorting the stack using another stack.

// Example Input
// Input 1:

//  A = [5, 4, 3, 2, 1]
// Input 2:

//  A = [5, 17, 100, 11]

// Example Output
// Output 1:

//  [1, 2, 3, 4, 5]
// Output 2:

//  [5, 11, 17, 100]

public class Solution {
    public int[] solve(int[] A) {
        Stack<Integer> origin = new Stack();

        for (int i = 0; i < A.length; i++)
            origin.push(A[i]);

        sort(origin);

        int[] ans = new int[A.length];
        int i = 0;
        while (!origin.isEmpty()) {
            ans[i] = origin.peek();
            origin.pop();
            i++;
        }
        return ans;
    }

    public void sort(Stack<Integer> origin) {
        // Base case
        if (origin.isEmpty())
            return;

        int temp = origin.peek();
        origin.pop();
        sort(origin);
        sorted_insert(origin, temp);
    }

    public void sorted_insert(Stack<Integer> origin, int x) {
        Stack<Integer> temp_stk = new Stack<>();
        while (!origin.isEmpty() && origin.peek() < x) {
            int temp1 = origin.peek();
            temp_stk.push(temp1);
            origin.pop();
        }
        origin.push(x);

        while (!temp_stk.isEmpty()) {
            int temp1 = temp_stk.peek();
            origin.push(temp1);
            temp_stk.pop();
        }
    }
}
