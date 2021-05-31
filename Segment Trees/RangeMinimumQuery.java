// Range Minimum Query
// Problem Description

// Given an integer array A of size N.

// You have to perform two types of query, in each query you are given three integers x,y,z.

// If x = 0, then update A[y] = z.
// If x = 1, then output the minimum element in the array A between index y and z inclusive.
// Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.

// Problem Constraints
// 1 <= N, M <= 105

// 1 <= A[i] <= 109

// If x = 0, 1<= y <= N and 1 <= z <= 109

// If x = 1, 1<= y <= z <= N

// Input Format
// First argument is an integer array A of size N.

// Second argument is a 2-D array B of size M x 3 denoting queries.

// Output Format
// Return an integer array denoting the output of each query where value of x is 1.

// Example Input
// Input 1:

//  A = [1, 4, 1]
//  B = [ 
//         [1, 1, 3]
//         [0, 1, 5]
//         [1, 1, 2] 
//      ]
// Input 2:

//  A = [5, 4, 5, 7]
//  B = [ 
//         [1, 2, 4]
//         [0, 1, 2]
//         [1, 1, 4]
//      ]

// Example Output
// Output 1:

//  [1, 4]
// Output 2:

//  [4, 2]

// Example Explanation
// Explanation 1:

//  For 1st query, the minimum element from range (1, 3) is 1.
//  For 2nd query, update A[1] = 5, now A = [5, 4, 1].
//  For 3rd query, the minimum element from range (1, 2) is 4.
// Explanation 2:

//  For 1st query, the minimum element from range (2, 4) is 4.
//  For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
//  For 3rd query, the minimum element from range (1, 4) is 2.

public class Solution {
    ArrayList<Integer> tree = new ArrayList<Integer>();

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();

        for (int i = 0; i < 4 * n; i++)
            tree.add(0);

        buildSegmentTree(0, 0, n - 1, A);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (ArrayList<Integer> query : B) {
            if (query.get(0) == 0) {
                updateSegmentTree(0, 0, n - 1, query.get(1) - 1, query.get(2));
            } else if (query.get(0) == 1) {
                res.add(findRangeMinimum(0, 0, n - 1, query.get(1) - 1, query.get(2) - 1));
            }
        }

        return res;
    }

    public void buildSegmentTree(int index, int low, int high, ArrayList<Integer> A) {
        // Base Case
        if (low == high) {
            tree.set(index, A.get(low));
            return;
        }

        int mid = (low + high) / 2;

        // leftchild
        buildSegmentTree(2 * index + 1, low, mid, A);
        // rightChild
        buildSegmentTree(2 * index + 2, mid + 1, high, A);

        tree.set(index, Math.min(tree.get(2 * index + 1), tree.get(2 * index + 2)));

        return;
    }

    public int findRangeMinimum(int index, int low, int high, int qL, int qR) {

        // No Overlap
        if (high < qL || low > qR)
            return Integer.MAX_VALUE;

        // Complete Overlap
        if (low >= qL && high <= qR) {
            return tree.get(index);
        }

        // Partial Overlap
        int mid = (low + high) / 2;

        int ans_left = findRangeMinimum(2 * index + 1, low, mid, qL, qR);
        int ans_right = findRangeMinimum(2 * index + 2, mid + 1, high, qL, qR);

        return Math.min(ans_left, ans_right);

    }

    public void updateSegmentTree(int index, int low, int high, int i, int val) {
        // Base Case
        if (low == high) {
            tree.set(index, val);
            return;
        }

        int mid = (low + high) / 2;

        // i lies in left
        if (i <= mid) {
            updateSegmentTree(index * 2 + 1, low, mid, i, val);
        } else {
            updateSegmentTree(index * 2 + 2, mid + 1, high, i, val);
        }

        // update the parent
        tree.set(index, Math.min(tree.get(2 * index + 1), tree.get(2 * index + 2)));

        return;

    }

}
