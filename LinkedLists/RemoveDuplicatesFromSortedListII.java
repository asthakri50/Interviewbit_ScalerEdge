// Remove Duplicates from Sorted List II
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null || A.next == null)
            return A;
        // if not equal
        if (A.val != A.next.val) {
            // check for the remaining list
            A.next = deleteDuplicates(A.next);
            return A;
        } else {
            int temp = A.val;
            while (A != null && A.val == temp)
                // not a part of linked list
                A = A.next;

            return deleteDuplicates(A);
        }

    }
}
