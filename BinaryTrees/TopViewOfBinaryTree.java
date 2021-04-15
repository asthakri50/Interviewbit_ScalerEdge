// TOP VIEW
// Problem Description

// Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

// Right view of a Binary Tree is a set of nodes visible when the tree is visited from top.

// Return the nodes in any order.

// Problem Constraints
// 1 <= Number of nodes in binary tree <= 100000

// 0 <= node values <= 10^9

// Input Format
// First and only argument is head of the binary tree A.

// Output Format
// Return an array, representing the top view of the binary tree.

// Example Input
// Input 1:

//             1
//           /   \
//          2    3
//         / \  / \
//        4   5 6  7
//       /
//      8 
// Input 2:

//             1
//            /  \
//           2    3
//            \
//             4
//              \
//               5

// Example Output
// Output 1:

//  [1, 2, 4, 8, 3, 7]
// Output 2:

//  [1, 2, 3]

// Example Explanation
// Explanation 1:

// Top view is described.
// Explanation 2:

// Top view is described.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Solution {
    static class Pair {
        TreeNode t;
        int x;

        Pair(TreeNode t, int x) {
            this.t = t;
            this.x = x;
        }
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        ArrayList<Integer> ar = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int v = p.t.val;
            int x = p.x;
            ar = new ArrayList<Integer>();
            if (tm.containsKey(x)) {
                ar = tm.get(x);
                ar.add(v);
            } else {
                ar.add(v);
            }

            tm.put(x, ar);
            if (p.t.left != null) {
                q.add(new Pair(p.t.left, x - 1));
            }
            if (p.t.right != null) {
                q.add(new Pair(p.t.right, x + 1));
            }
        }
        for (int x : tm.keySet()) {
            ArrayList<Integer> f = tm.get(x);
            ans.add(f);
        }

        for (ArrayList<Integer> li : ans)
            res.add(li.get(0));

        return res;
    }
}
