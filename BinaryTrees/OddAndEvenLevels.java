// Odd and Even Levels
// Problem Description

// Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

// NOTE: Consider the level of root node as 1.

// Problem Constraints
// 1 <= Number of nodes in binary tree <= 100000

// 0 <= node values <= 109

// Input Format
// First and only argument is a root node of the binary tree, A

// Output Format
// Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.

// Example Input
// Input 1:

//         1
//       /   \
//      2     3
//     / \   / \
//    4   5 6   7
//   /
//  8 
// Input 2:

//         1
//        / \
//       2   10
//        \
//         4

// Example Output
// Output 1:

//  10
// Output 2:

//  -7

// Example Explanation
// Explanation 1:

//  Sum of nodes at odd level = 23
//  Sum of ndoes at even level = 13
// Explanation 2:

//  Sum of nodes at odd level = 5
//  Sum of ndoes at even level = 12

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    public int solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();

        int sum_odd = 0;
        int sum_even = 0;

        queue.add(A);
        int count = 0;

        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(A, 1);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek();

            if (map.get(temp) % 2 == 0)
                sum_even += temp.val;
            else
                sum_odd += temp.val;

            queue.remove();

            if (temp.left != null) {
                queue.add(temp.left);
                map.put(temp.left, map.get(temp) + 1);
            }

            if (temp.right != null) {
                queue.add(temp.right);
                map.put(temp.right, map.get(temp) + 1);
            }

        }
        // System.out.println(sum_even +" "+ sum_odd) ;
        return sum_odd - sum_even;
    }
}
