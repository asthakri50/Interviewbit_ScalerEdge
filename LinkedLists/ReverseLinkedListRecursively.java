// Reverse Linked List Recursively
// Problem Description

// You are given a singly linked list having head node A. You have to reverse the linked list recursively and return the head node of that reversed list.

// Problem Constraints
// 1 <= Length of linked list <= 105

// Value of each node is within the range of a 32-bit integer.

// Input Format
// First and only argument is a linked-list node A.

// Output Format
// Return a linked-list node denoting the head of the reversed linked list.

// Example Input
// Input 1:

//  A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
// Input 2:

//  A = 3 -> NULL 

// Example Output
// Output 1:

//  5 -> 4 -> 3 -> 2 -> 1 -> NULL 
// Output 2:

//  3 -> NULL 

// Example Explanation
// Explanation 1:

//  The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
// Expalantion 2:

//  The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL 

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // Base Case
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
