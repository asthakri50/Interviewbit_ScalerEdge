// Binary Tree From Inorder And Postorder
// Problem Description

// Given inorder and postorder traversal of a tree, construct the binary tree.

// NOTE: You may assume that duplicates do not exist in the tree.

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First argument is an integer array A denoting the inorder traversal of the tree.

// Second argument is an integer array B denoting the postorder traversal of the tree.

// Output Format
// Return the root node of the binary tree.

// Example Input
// Input 1:

//  A = [2, 1, 3]
//  B = [2, 3, 1]
// Input 2:

//  A = [6, 1, 3, 2]
//  B = [6, 3, 2, 1]

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
        int in_strt = 0;
        int in_end = A.size() - 1;
        int po_strt = 0;
        int po_end = B.size() - 1;
        return builder(A, B, in_strt, in_end, po_strt, po_end);
    }

    public TreeNode builder(ArrayList<Integer> A, ArrayList<Integer> B, int in_strt, int in_end, int po_strt,
            int po_end) {
        if (in_strt > in_end)
            return null;

        TreeNode root = new TreeNode(B.get(po_end));

        if (in_strt == in_end)
            return root;

        int i = findIdx(A, in_strt, in_end, root.val);

        root.left = builder(A, B, in_strt, i - 1, po_strt, po_strt + i - in_strt - 1);
        root.right = builder(A, B, i + 1, in_end, po_strt + i - in_strt, po_end - 1);

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