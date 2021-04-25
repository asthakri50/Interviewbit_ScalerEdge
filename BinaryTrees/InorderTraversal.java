// Inorder Traversal
// Problem Description

// Given a binary tree, return the inorder traversal of its nodes values.

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First and only argument is root node of the binary tree, A.

// Output Format
// Return an integer array denoting the inorder traversal of the given binary tree.

// Example Input
// Input 1:

//    1
//     \
//      2
//     /
//    3
// Input 2:

//    1
//   / \
//  6   2
//     /
//    3

// Example Output
// Output 1:

//  [1, 3, 2]
// Output 2:

//  [6, 1, 3, 2]

// Example Explanation
// Explanation 1:

//  The Inorder Traversal of the given tree is [1, 3, 2].
// Explanation 2:

//  The Inorder Traversal of the given tree is [6, 1, 3, 2].

//Approach 1:- Using Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        return inorder(A, ans);
    }

    public ArrayList<Integer> inorder(TreeNode A, ArrayList<Integer> ans) {
        if (A == null)
            return ans;

        inorder(A.left, ans);
        ans.add(A.val);
        inorder(A.right, ans);

        return ans;

    }
}

// Approach 2:- Without Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stk = new Stack();

        TreeNode curr = A;

        while (curr != null || stk.size() > 0) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}
