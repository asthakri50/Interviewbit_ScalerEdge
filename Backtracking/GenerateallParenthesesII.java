// Generate all Parentheses II
// Problem Description

// Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

// Problem Constraints
// 1 <= A <= 20

// Input Format
// First and only argument is integer A.

// Output Format
// Return a sorted list of all possible paranthesis.

// Example Input
// Input 1:

// A = 3
// Input 2:

// A = 1

// Example Output
// Output 1:

// [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
// Output 2:

// [ "()" ]

// Example Explanation
// Explanation 1:

//  All paranthesis are given in the output list.
// Explanation 2:

//  All paranthesis are given in the output list.

public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res = new ArrayList<String>();
        int open = 0;
        int close = 0;
        StringBuffer str = new StringBuffer();
        int index = 0;

        findAll(index, open, close, A, str, res);

        return res;
    }

    public void findAll(int index, int open, int close, int A, StringBuffer str, ArrayList<String> res) {
        // Base Case
        if (open == A && close == A) {
            res.add(str.toString());
            return;
        }
        // we can add open parentheses , hence one open parentheses added
        if (open < A) {
            str = new StringBuffer(str.toString());
            str = str.append('(');
            open = open + 1;
            // System.out.println(str +" " + open +" "+ close) ;
            findAll(index + 1, open, close, A, str, res);
            str.deleteCharAt(str.length() - 1);
            open = open - 1;

        }

        // we can add close parentheses, hence one close parentheses added
        if (close < open) {
            str = new StringBuffer(str.toString());
            str = str.append(')');
            close = close + 1;
            // System.out.println(str +" " + open +" " + close) ;
            findAll(index + 1, open, close, A, str, res);
            str.deleteCharAt(str.length() - 1);
            close = close - 1;
        }

    }

}
