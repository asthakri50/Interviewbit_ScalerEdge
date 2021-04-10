// Nodes Count
// Problem Description

// You are given the root node of a binary tree A. You have to find the number of nodes in this tree.

// Problem Constraints
// 1 <= Number of nodes in the tree <= 105

// 0 <= Value of each node <= 107

// Input Format
// First and only argument is a tree node A.

// Output Format
// Return an integer denoting the number of nodes of the tree.

// Example Input
// Input 1:

//  Values =  1 
//           / \     
//          4   3                        
// Input 2:

//  Values =  1      
//           / \     
//          4   3                       
//         /         
//        2                                     

// Example Output
// Output 1:

//  3 
// Output 2:

//  4 

// Example Explanation
// Explanation 1:

// Clearly, there are 3 nodes 1, 4 and 3.
// Explanation 2:

// Clearly, there are 4 nodes 1, 4, 3 and 2.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public int solve(TreeNode A) {
        // Base Case
        if (A == null)
            return 0;

        int left_count = solve(A.left);

        int right_count = solve(A.right);

        return left_count + right_count + 1;
    }
}
