// Right view of Binary tree
// Problem Description

// Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

// Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

// Problem Constraints
// 1 <= Number of nodes in binary tree <= 100000

// 0 <= node values <= 10^9

// Input Format
// First and only argument is head of the binary tree A.

// Output Format
// Return an array, representing the right view of the binary tree.

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

//  [1, 3, 7, 8]
// Output 2:

//  [1, 3, 4, 5]

// Example Explanation
// Explanation 1:

// Right view is described.
// Explanation 2:

// Right view is described.

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

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<Pair>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (A == null)
            return res;

        Pair p = new Pair(A, 1);
        queue.add(p);
        int curr_level = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            Pair temp = queue.peek();
            if (temp.x == curr_level) {
                list.add(temp.t.val);
            } else {
                arr.add(list);
                curr_level++;
                list = new ArrayList<Integer>();
                list.add(temp.t.val);
            }
            queue.remove();

            if (temp.t.left != null) {
                queue.add(new Pair(temp.t.left, temp.x + 1));
            }

            if (temp.t.right != null) {
                queue.add(new Pair(temp.t.right, temp.x + 1));
            }
        }

        arr.add(list);
        // System.out.println(arr) ;

        for (ArrayList<Integer> li : arr) {
            res.add(li.get(li.size() - 1));
        }
        return res;
    }
}
