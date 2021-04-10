// Problem Description

// Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

// insert_node(position, value) - To insert the input value at the given position in the linked list.
// delete_node(position) - Delete the value at the given position from the linked list.
// print_ll() - Print the entire linked list, such that each element is followed by a single space.
// Note:

// If an input position does not satisfy the constraint, no action is required.
// Each print query has to be executed in new line.

// Problem Constraints
// 1 <= position <= n where, n is the size of the linked-list.

// Input Format
// First line contains an integer denoting number of cases, let's say t.
// Next t line denotes the cases.

// Output Format
// When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
// NOTE: You don't need to return anything.

// Example Input
// 5
// i 1 23
// i 2 24
// p
// d 1
// p

// Example Output
// 23 24
// 24

// Example Explanation
// After first two cases linked list contains two elements 23 and 24.
// At third case print: 23 24.
// At fourth case delete value at first position, only one element left 24.
// At fifth case print: 24.

static class Node {

    int val;

    Node next = null;

    Node(int val) {

        this.val = val;
    }

    }

    static Node head = null;

    static int length = 0;

    public static void insert_node(int position, int value) {

        Node temp = head;

        Node node = new Node(value);

        int pos = 1;

        Node prev = null;

        if (position <= length + 1) {

            while (position != pos) {

                prev = temp;

                temp = temp.next;

                pos++;

            }

            if (position == 1) {

                node.next = temp;

                head = node;

            } else if (temp == null) {

                prev.next = node;

            } else {

                prev.next = node;

                node.next = temp;
            }

            length++;

        }

    }

    public static void delete_node(int position) {

        Node temp = head;

        Node prev = temp;

        if (position == 1 && length != 0) {

            head = head.next;

            length--;

        } else if (position <= length) {

            while (position != 1) {

                prev = temp;

                temp = temp.next;

                position--;

            }

            if (temp.next == null) {

                prev.next = null;

            } else {

                prev.next = temp.next;

            }

            length--;

        }

    }

public static void print_ll() {

   Node temp = head;
   
    while(temp!=null) {


       System.out.print(temp.val);



       temp = temp.next;

   }
    return ;

       if(temp.next != null) System.out.print(" ");
   }
