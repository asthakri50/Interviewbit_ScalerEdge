// Merge K Sorted Lists
// Problem Description

// Given a list containing head pointers of N sorted linked lists. Merge these N given sorted linked lists and return it as one sorted list.

// Problem Constraints
// 1 <= total number of elements in given linked lists <= 100000

// Input Format
// First and only argument is a list containing N head pointers.

// Output Format
// Return a pointer to the head of the sorted linked list after merging all the given linked lists.

// Example Input
// Input 1:

//  1 -> 10 -> 20
//  4 -> 11 -> 13
//  3 -> 8 -> 9
// Input 2:

//  10 -> 12
//  13
//  5 -> 6

// Example Output
// Output 1:

//  1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
// Output 2:

//  5 -> 6 -> 10 -> 12 ->13

// Example Explanation
// Explanation 1:

//  The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
// Explanation 2:

//  The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13. 

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int N = a.size();
        ListNode head = null;
        ListNode tail = null;

        // Min Heap of size N
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(N, (p, q) -> p.val - q.val);

        // Insert head Pointers of these lists
        for (int i = 0; i < N; i++)
            pq.add(a.get(i));

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            if (temp.next != null)
                pq.add(temp.next);
        }

        return head;
    }
}
