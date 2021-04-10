// Swap List Nodes in pairs
// Problem Description

// Given a linked list A, swap every two adjacent nodes and return its head.

// NOTE: Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

// Problem Constraints
// 1 <= |A| <= 106

// Input Format
// The first and the only argument of input contains a pointer to the head of the given linked list.

// Output Format
// Return a pointer to the head of the modified linked list.

// Example Input
// Input 1:

//  A = 1 -> 2 -> 3 -> 4
// Input 2:

//  A = 7 -> 2 -> 1

// Example Output
// Output 1:

//  2 -> 1 -> 4 -> 3
// Output 2:

//  2 -> 7 -> 1

// Example Explanation
// Explanation 1:

//  In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
// Explanation 2:

//  In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        // Base Case
        if (A == null)
            return A;

        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;

        while (curr != null && count < 2) {
            // Reversing first 2 nodes
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        A.next = swapPairs(curr);
        return prev;
    }
}
