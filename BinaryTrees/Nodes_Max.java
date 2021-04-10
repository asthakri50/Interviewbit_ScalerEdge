// package BinaryTrees;

// Nodes Max
// Problem Description

// You are given the root node of a binary tree A. You have to find the max value of all node values of this tree.

// Problem Constraints
// 1 <= Number of nodes in the tree <= 105

// 0 <= Value of each node <= 104

// Input Format
// First and only argument is a tree node A.

// Output Format
// Return an integer denoting the max of all node values of the tree.

// Example Input
// Input 1:

//  Values =  1 
//           / \     
//          4   3                        
// Input 2:

//  Values =  1      
//           / \     
//          8   3                       
//         /         
//        2                                     

// Example Output
// Output 1:

//  4 
// Output 2:

//  8 

// Example Explanation
// Explanation 1:

// Clearly, among 1, 4, 3: 4 is maximum.
// Explanation 2:

// Clearly, among 1, 8, 3, 2: 8 is maximum.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public int solve(TreeNode A) {
        if (A == null)
            return Integer.MIN_VALUE;

        int left_max = solve(A.left);

        int right_max = solve(A.right);

        return Math.max(Math.max(left_max, right_max), A.val);
    }
}
