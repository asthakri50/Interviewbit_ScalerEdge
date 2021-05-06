// Next Pointer Binary Tree
// Problem Description

// Given a binary tree,

// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Assume perfect binary tree and try to solve this in constant extra space.

// Problem Constraints
// 1 <= Number of nodes in binary tree <= 100000

// 0 <= node values <= 10^9

// Input Format
// First and only argument is head of the binary tree A.

// Output Format
// Return the head of the binary tree after the changes are made.

// Example Input
// Input 1:

//      1
//     /  \
//    2    3
// Input 2:

//         1
//        /  \
//       2    5
//      / \  / \
//     3  4  6  7

// Example Output
// Output 1:

//         1 -> NULL
//        /  \
//       2 -> 3 -> NULL
// Output 2:

//          1 -> NULL
//        /  \
//       2 -> 5 -> NULL
//      / \  / \
//     3->4->6->7 -> NULL

// Example Explanation
// Explanation 1:

// Next pointers are set as given in the output.
// Explanation 2:

// Next pointers are set as given in the output.

/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
    static class Pair {
        TreeLinkNode node;
        int x;

        Pair(TreeLinkNode t, int x) {
            node = t;
            this.x = x;
        }
    }

    public void connect(TreeLinkNode root) {
        ArrayList<ArrayList<TreeLinkNode>> li = LevelOrder(root);

        for (ArrayList<TreeLinkNode> list : li) {
            for (int i = 0; i < list.size(); i++) {
                // Printing the list
                // System.out.print(list.get(i).val + " ");
                if (i == list.size() - 1) {
                    list.get(i).next = null;
                } else {
                    list.get(i).next = list.get(i + 1);
                }
            }
            // System.out.println("");
        }

        return;

    }

    public ArrayList<ArrayList<TreeLinkNode>> LevelOrder(TreeLinkNode root) {
        ArrayList<ArrayList<TreeLinkNode>> ans = new ArrayList<ArrayList<TreeLinkNode>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root, 0));
        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        int curr_level = 0;

        while (!queue.isEmpty()) {
            int level = queue.peek().x;
            TreeLinkNode TreeNode = queue.peek().node;
            if (level == curr_level) {
                list.add(TreeNode);
            } else {
                ans.add(list);
                list = new ArrayList<TreeLinkNode>();
                list.add(TreeNode);
                curr_level++;
            }
            if (TreeNode.left != null)
                queue.add(new Pair(TreeNode.left, level + 1));
            if (TreeNode.right != null)
                queue.add(new Pair(TreeNode.right, level + 1));

            queue.poll();
        }

        ans.add(list);
        return ans;
    }
}

// Shortcut==>

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);

        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeLinkNode front = q.poll();
                if (i == n - 1) {
                    front.next = null;
                } else {
                    front.next = q.peek();
                }
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
        }
        return;
    }
}
