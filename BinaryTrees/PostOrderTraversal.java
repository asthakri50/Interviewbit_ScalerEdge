// Postorder Traversal
// Problem Description

// Given a binary tree, return the Postorder traversal of its nodes values.

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First and only argument is root node of the binary tree, A.

// Output Format
// Return an integer array denoting the Postorder traversal of the given binary tree.

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

//  [3, 2, 1]
// Output 2:

//  [6, 3, 2, 1]

// Example Explanation
// Explanation 1:

//  The Postoder Traversal of the given tree is [3, 2, 1].
// Explanation 2:

//  The Postorder Traversal of the given tree is [6, 3, 2, 1].

//Approach 1:- Using Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        return postorder(A, ans);
    }

    public ArrayList<Integer> postorder(TreeNode A, ArrayList<Integer> ans) {
        if (A == null)
            return ans;

        ans = postorder(A.left, ans);
        ans = postorder(A.right, ans);

        ans.add(A.val);

        return ans;
    }
}

// Approach 2:- Without Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */

// Post Order is left , right , then root
// Reverse of post Order is root , right ,then left
// Store reverse of post order in a stack
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> rev = new Stack<>();

        stk.push(A);
        TreeNode temp = null;
        while (!stk.isEmpty()) {
            temp = stk.peek();
            rev.push(temp.val);
            stk.pop();
            // first push left
            if (temp.left != null)
                stk.push(temp.left);

            if (temp.right != null)
                stk.push(temp.right);
        }

        while (!rev.isEmpty()) {
            res.add(rev.peek());
            rev.pop();
        }
        return res;

    }
}
