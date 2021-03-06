// Binary Tree From Inorder And Preorder
// Problem Description

// Given preorder and inorder traversal of a tree, construct the binary tree.

// NOTE: You may assume that duplicates do not exist in the tree.

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First argument is an integer array A denoting the preorder traversal of the tree.

// Second argument is an integer array B denoting the inorder traversal of the tree.

// Output Format
// Return the root node of the binary tree.

// Example Input
// Input 1:

//  A = [1, 2, 3]
//  B = [2, 1, 3]
// Input 2:

//  A = [1, 6, 2, 3]
//  B = [6, 1, 3, 2]

// Example Output
// Output 1:

//    1
//   / \
//  2   3
// Output 2:

//    1  
//   / \
//  6   2
//     /
//    3

// Example Explanation
// Explanation 1:

//  Create the binary tree and return the root node of the tree.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0)
            return null;

        int pre_strt = 0;
        int pre_end = A.size() - 1;
        int in_strt = 0;
        int in_end = B.size() - 1;

        return builder(A, B, pre_strt, pre_end, in_strt, in_end);
    }

    public TreeNode builder(ArrayList<Integer> A, ArrayList<Integer> B, int pre_strt, int pre_end, int in_strt,
            int in_end) {
        // Base Case
        if (in_strt > in_end)
            return null;

        TreeNode root = new TreeNode(A.get(pre_strt));

        if (in_strt == in_end)
            return root;

        int i = findIdx(B, in_strt, in_end, root.val);

        root.left = builder(A, B, pre_strt + 1, pre_strt + i - in_strt, in_strt, i - 1);
        root.right = builder(A, B, pre_strt + i - in_strt + 1, pre_end, i + 1, in_end);

        return root;
    }

    public int findIdx(ArrayList<Integer> A, int start, int end, int num) {
        for (int i = start; i <= end; i++) {
            if (A.get(i) == num)
                return i;
        }

        return -1;
    }
}