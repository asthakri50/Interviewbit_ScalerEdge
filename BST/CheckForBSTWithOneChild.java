// Check for BST with One Child
// Problem Description

// Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

// Problem Constraints
// 1 <= number of nodes <= 100000

// Input Format
// First and only argument is an integer array denoting the preorder traversal of binary tree.

// Output Format
// Return a string "YES" if true else "NO".

// Example Input
// Input 1:

//  A : [4, 10, 5, 8]
// Input 2:

//  A : [1, 5, 6, 4]

// Example Output
// Output 1:

//  "YES"
// Output 2:

//  "NO"

// Example Explanation
// Explanation 1:

//  The possible BST is:
//             4
//              \
//              10
//              /
//              5
//               \
//               8
// Explanation 2:

//  There is no possible BST which have the above preorder traversal.

public class Solution {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    int root = 0;

    public String solve(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            if (i > 0)
                root = A.get(i - 1);
            else
                root = A.get(0);

            boolean ans = checkRange(A.get(i));
            if (!ans)
                return "NO";
        }

        return "YES";
    }

    public boolean checkRange(int num) {

        if (num > root) // will go in right subtree
            min = root + 1;

        else if (num < root) // will go in left subtree
            max = root - 1;

        if (num < min || num > max)
            return false;

        return true;
    }
}
