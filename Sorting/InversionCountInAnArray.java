// Inversion count in an array
// Problem Description

// Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

// Problem Constraints
// 1 <= length of the array <= 100000

// 1 <= A[i] <= 10^9

// Input Format
// The only argument given is the integer array A.

// Output Format
// Return the number of inversions of A modulo (109 + 7).

// Example Input
// Input 1:

// A = [3, 2, 1]
// Input 2:

// A = [1, 2, 3]

// Example Output
// Output 1:

// 3
// Output 2:

// 0

// Example Explanation
// Explanation 1:

//  All pairs are inversions.
// Explanation 2:

//  No inversions.

//Approach !-> TLE
public class Solution {
    public int solve(ArrayList<Integer> A) {
        int count = 0;
        int mod = 1000000007;

        // Using inserted sort approach
        for (int i = 1; i < A.size(); i++) {
            int j = i;
            while (j > 0 && A.get(j - 1) > A.get(j)) {
                // inversion pair
                count = count % mod + 1;
                // swap
                int temp = A.get(j - 1);
                A.set(j - 1, A.get(j));
                A.set(j, temp);
                j--;
            }
        }
        return count;
    }

}

// Efficient Approach -> O(nlogn)
// Merge Sort
public class Solution {
    int M = 1000000007;

    public int solve(int[] A) {
        return mergeSortAndCount(A, 0, A.length - 1);
    }

    // Function to count the number of inversions
    // during the merge process
    private int mergeAndCount(int[] arr, int l, int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    // Merge sort function
    private int mergeSortAndCount(int[] arr, int l, int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count = count % M + mergeSortAndCount(arr, l, m) % M;

            // Right subarray count
            count = count % M + mergeSortAndCount(arr, m + 1, r) % M;

            // Merge count
            count = count % M + mergeAndCount(arr, l, m, r) % M;
        }

        return count;
    }

}
