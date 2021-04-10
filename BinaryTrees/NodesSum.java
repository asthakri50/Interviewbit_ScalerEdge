// Nodes Sum
// Problem Description

// You are given the root node of a binary tree A. You have to find the sum of node values of this tree.

// Problem Constraints
// 1 <= Number of nodes in the tree <= 105

// 0 <= Value of each node <= 104

// Input Format
// First and only argument is a tree node A.

// Output Format
// Return an integer denoting the sum of node values of the tree.

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

//  8 
// Output 2:

//  14 

// Example Explanation
// Explanation 1:

// Clearly, 1 + 4 + 3 = 8.
// Explanation 2:

// Clearly, 1 + 8 + 3 + 2 = 14.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public int solve(TreeNode A) {
        // Base Case
        if (A == null)
            return 0;

        int left_sum = solve(A.left);

        int right_sum = solve(A.right);

        return left_sum + right_sum + A.val;
    }
}
