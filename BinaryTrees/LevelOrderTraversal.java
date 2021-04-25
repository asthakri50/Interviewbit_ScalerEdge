// Level Order
// Problem Description

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// Problem Constraints
// 1 <= number of nodes <= 105

// Input Format
// First and only argument is root node of the binary tree, A.

// Output Format
// Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

// Example Input
// Input 1:

//     3
//    / \
//   9  20
//     /  \
//    15   7
// Input 2:

//    1
//   / \
//  6   2
//     /
//    3

// Example Output
// Output 1:

//  [
//    [3],
//    [9, 20],
//    [15, 7]
//  ]
// Output 2:

//  [ 
//    [1]
//    [6, 2]
//    [3]
//  ]

// Example Explanation
// Explanation 1:

//  Return the 2D array. Each row denotes the traversal of each level.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
// Approach 1:-
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        if (A == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(A);

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            ArrayList<Integer> list = new ArrayList<Integer>();
            while (nodeCount > 0) {
                TreeNode node = q.peek();
                list.add(node.val);
                q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                nodeCount--;
            }
            ans.add(list);
        }

        return ans;

    }
}

// Approach 2:-
public class Solution {
    static class Pair {
        TreeNode node;
        int x;

        Pair(TreeNode t, int x) {
            node = t;
            this.x = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();

        queue.add(new Pair(A, 0));
        int curr_level = 0;
        ArrayList<Integer> li = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek().node;
            int level = queue.peek().x;
            if (temp.left != null)
                queue.add(new Pair(temp.left, level + 1));
            if (temp.right != null)
                queue.add(new Pair(temp.right, level + 1));

            if (curr_level == level)
                li.add(temp.val);
            else {
                ans.add(li);
                li = new ArrayList<Integer>();
                li.add(temp.val);
                curr_level++;
            }
            queue.remove();
        }
        ans.add(li);

        return ans;
    }
}
