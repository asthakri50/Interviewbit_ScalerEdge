// Minimum largest element
// Problem Description

// Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add original value(value stored at index before we did any operations) to it's current value. You can choose any of the N elements in each operation.

// Perform B operations in such a way that the largest element of the modified array(after B operations) is minimised. Find the minimum possible largest element after B operations.

// Problem Constraints
// 1 <= N <= 106
// 0 <= B <= 105
// -105 <= A[i] <= 105

// Input Format
// First argument is an integer array A.
// Second argument is an integer B.

// Output Format
// Return an integer denoting the minimum possible largest element after B operations.

// Example Input
// Input 1:

//  A = [1, 2, 3, 4] 
//  B = 3
// Input 2:

//  A = [5, 1, 4, 2] 
//  B = 5

// Example Output
// Output 1:

//  4
// Output 2:

//  5

// Example Explanation
// Explanation 1:

//  Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
//  Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
//  Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
//  Minimum possible largest element after 3 operations is 4.
// Explanation 2:

//  Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
//  Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
//  Minimum possible largest element after 5 operations is 5.

public class Solution {
    static class Pair {
        int curr;
        int idx;

        Pair(int x, int y) {
            curr = x;
            idx = y;
        }
    }

    public int solve(ArrayList<Integer> A, int B) {
        // Min Heap containing next state of elements in array.
        // So we will perform the operation to the element whose next state is minimum.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.curr - b.curr);
        int n = A.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = A.get(i);

        for (int i = 0; i < A.size(); i++)
            pq.add(new Pair(2 * A.get(i), i));

        for (int i = 0; i < B; i++) {
            Pair temp = pq.peek();
            int min = temp.curr;
            int index = temp.idx;
            pq.poll();
            res[index] = min;
            pq.add(new Pair(min + A.get(index), index));
        }

        // get the largest number of this min heap
        int max = Integer.MIN_VALUE;

        // while(!pq.isEmpty() ){
        // max = Math.max(pq.peek().curr , max) ;
        // pq.poll() ;
        // }

        for (int i = 0; i < n; i++)
            max = Math.max(max, res[i]);

        return max;

    }
}
