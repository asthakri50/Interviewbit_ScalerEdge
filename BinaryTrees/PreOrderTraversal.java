// Preorder Traversal
// Problem Description

// Given a binary tree, return the preorder traversal of its nodes values.

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First and only argument is root node of the binary tree, A.

// Output Format
// Return an integer array denoting the preorder traversal of the given binary tree.

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

//  [1, 2, 3]
// Output 2:

//  [1, 6, 2, 3]

// Example Explanation
// Explanation 1:

//  The Preoder Traversal of the given tree is [1, 2, 3].
// Explanation 2:

//  The Preoder Traversal of the given tree is [1, 6, 2, 3].

//Approach 1:- Using Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        return preorder(A, ans);
    }

    public ArrayList<Integer> preorder(TreeNode A, ArrayList<Integer> ans) {
        if (A == null)
            return ans;

        ans.add(A.val);
        ans = preorder(A.left, ans);
        ans = preorder(A.right, ans);

        return ans;
    }
}

// Approach 2:- Without Recursion
/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        Stack<TreeNode> stk = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stk.push(A);
        TreeNode temp;

        if (A == null)
            return res;

        while (!stk.isEmpty()) {
            temp = stk.peek();
            res.add(temp.val);
            stk.pop();
            if (temp.right != null)
                stk.push(temp.right);

            if (temp.left != null)
                stk.push(temp.left);
        }

        return res;
    }
}
