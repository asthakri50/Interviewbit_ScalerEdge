// Reverse Link List II
// Problem Description

// Reverse a linked list A from position B to C.

// NOTE: Do it in-place and in one-pass.

// Problem Constraints
// 1 <= |A| <= 106

// 1 <= B <= C <= |A|

// Input Format
// The first argument contains a pointer to the head of the given linked list, A.

// The second arugment contains an integer, B.

// The third argument contains an integer C.

// Output Format
// Return a pointer to the head of the modified linked list.

// Example Input
// Input 1:

//  A = 1 -> 2 -> 3 -> 4 -> 5
//  B = 2
//  C = 4

// Input 2:

//  A = 1 -> 2 -> 3 -> 4 -> 5
//  B = 1
//  C = 5

// Example Output
// Output 1:

//  1 -> 4 -> 3 -> 2 -> 5
// Output 2:

//  5 -> 4 -> 3 -> 2 -> 1

// Example Explanation
// Explanation 1:

//  In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
//  Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
// Explanation 2:

//  In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
//  Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (B == C)
            return A;

        ListNode strt = null;
        ListNode prev_strt = null;

        ListNode end = null;
        ListNode next_end = null;

        int i = 1;
        ListNode temp = A;

        while (temp != null && i <= C) {
            if (i < B)
                prev_strt = temp;

            if (i == B)
                strt = temp;

            if (i == C) {
                end = temp;
                next_end = temp.next;
            }
            temp = temp.next;
            i++;
        }
        end.next = null;

        end = reverse(strt);
        if (prev_strt != null)
            prev_strt.next = end;
        else
            A = end;

        strt.next = next_end;

        return A;
    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
