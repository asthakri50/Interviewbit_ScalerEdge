// Kth Smallest Element in a Sorted Matrix
// Problem Description

// Given a sorted matrix of integers A of size N x M and an integer B.

// Each of the rows and columns of matrix A are sorted in ascending order, find the Bth smallest element in the matrix.

// NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

// Problem Constraints
// 1 <= N, M <= 500

// 1 <= A[i] <= 109

// 1 <= B <= N * M

// Input Format
// The first argument given is the integer matrix A.
// The second argument given is an integer B.

// Output Format
// Return the B-th smallest element in the matrix.

// Example Input
// Input 1:

//  A = [ [9, 11, 15],
//        [10, 15, 17] ] 
//  B = 6
// Input 2:

//  A = [  [5, 9, 11],
//         [9, 11, 13],
//         [10, 12, 15],
//         [13, 14, 16],
//         [16, 20, 21] ]
//  B = 12

// Example Output
// Output 1:

//  17
// Output 2:

//  16

// Example Explanation
// Explanation 1:

//  6th smallest element in the sorted matrix is 17.
// Explanation 2:

//  12th smallest element in the sorted matrix is 16.

public class Solution {

    static class Node {
        int val;
        int r;
        int c;

        Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int rows = A.size();
        int columns = A.get(0).size();
        // Min Heap
        PriorityQueue<Node> pq = new PriorityQueue<Node>(rows, (a, b) -> a.val - b.val);

        // Insert first element of each arrayList
        for (int row = 0; row < rows; row++) {
            pq.add(new Node(A.get(row).get(0), row, 0));
        }

        int count = 0;
        while (count < B - 1) {
            int row = pq.peek().r;
            int col = pq.peek().c;

            pq.poll();
            count++;

            if (col < columns - 1)
                pq.add(new Node(A.get(row).get(col + 1), row, col + 1));
        }

        return pq.peek().val;
    }

}
