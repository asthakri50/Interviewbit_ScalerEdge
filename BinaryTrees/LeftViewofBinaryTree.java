// Left view of binary tree
// Problem Description

// Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

// Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

// NOTE: The value comes first in the array which have lower level.

// Problem Constraints
// 1 <= Number of nodes in binary tree <= 100000

// 0 <= node values <= 109

// Input Format
// First and only argument is a root node of the binary tree, A.

// Output Format
// Return an integer array denoting the left view of the Binary tree.

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

//  [1, 2, 4, 8]
// Output 2:

//  [1, 2, 4, 5]

// Example Explanation
// Explanation 1:

//  The Left view of the binary tree is returned.

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
            res.add(li.get(0));
        }
        return res;
    }
}
