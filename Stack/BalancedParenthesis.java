// Problem Description

// Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

// Refer to the examples for more clarity.



// Problem Constraints
// 1 <= |A| <= 100



// Input Format
// The first and the only argument of input contains the string A having the paranthesis sequence.



// Output Format
// Return 0, if the paranthesis sequence is not balanced.

// Return 1, if the paranthesis sequence is balanced.



// Example Input
// Input 1:

//  A = {([])}
// Input 2:

//  A = (){
// Input 3:

//  A = ()[] 


// Example Output
// Output 1:

//  1 
// Output 2:

//  0 
// Output 3:

//  1 


// Example Explanation
// You can clearly see that the first and third case contain valid paranthesis.

// In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.

    public class Solution {
    public int solve(String A) {
        Stack<Character> open_stack = new Stack();
        Stack<Character> close_stack = new Stack();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '[')
                open_stack.push(A.charAt(i));
            else if (A.charAt(i) == '{')
                open_stack.push(A.charAt(i));
            else if (A.charAt(i) == '(')
                open_stack.push(A.charAt(i));

            if (A.charAt(i) == ')') {
                if (!open_stack.isEmpty() && open_stack.peek() == '(')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            } else if (A.charAt(i) == '}') {
                if (!open_stack.isEmpty() && open_stack.peek() == '{')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            } else if (A.charAt(i) == ']') {
                if (!open_stack.isEmpty() && open_stack.peek() == '[')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            }
        }
        if (open_stack.isEmpty() && close_stack.isEmpty())
            return 1;

        return 0;

    }
}
