// Vertical Order traversal
// Problem Description

// Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.

// NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

// Problem Constraints
// 0 <= number of nodes <= 105

// Input Format
// First and only arument is a pointer to the root node of binary tree, A.

// Output Format
// Return a 2D array denoting the vertical order traversal of tree as shown.

// Example Input
// Input 1:

//       6
//     /   \
//    3     7
//   / \     \
//  2   5     9
// Input 2:

//       1
//     /   \
//    3     7
//   /       \
//  2         9

// Example Output
// Output 1:

//  [
//     [2],
//     [3],
//     [6, 5],
//     [7],
//     [9]
//  ]
// Output 2:

//  [
//     [2],
//     [3],
//     [1],
//     [7],
//     [9]
//  ]

// Example Explanation
// Explanation 1:

//  First row represent the verical line 1 and so on.

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> ar = new ArrayList<Integer>();
        if (root == null) {
            return ans;
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
        return ans;
    }
}
