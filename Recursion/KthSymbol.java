// Kth Symbol
// Problem Description

// On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

// Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).

// Problem Constraints
// 1 <= A <= 20

// 1 <= B <= 2A - 1

// Input Format
// First argument is an integer A.

// Second argument is an integer B.

// Output Format
// Return an integer denoting the Bth indexed symbol in row A.

// Example Input
// Input 1:

//  A = 2
//  B = 1
// Input 2:

//  A = 2
//  B = 2

// Example Output
// Output 1:

//  0
// Output 2:

//  1

// Example Explanation
// Explanation 1:

//  Row 1: 0
//  Row 2: 01
// Explanation 2:

//  Row 1: 0
//  Row 2: 01

public class Solution {

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public int solve(int A, int B) {
        buildList(A, B, 1);

        return res.get(A - 1).get(B - 1);
    }

    public void buildList(int A, int B, int curr) {
        ArrayList<Integer> li = new ArrayList<Integer>();

        if (curr > A)
            return;

        if (curr == 1) {
            li.add(0);
            res.add(li);
        } else {
            // since curr is 1 indexed.
            ArrayList<Integer> list = res.get(curr - 2);
            for (int i : list) {
                if (i == 0) {
                    li.add(0);
                    li.add(1);
                } else {
                    li.add(1);
                    li.add(0);
                }
            }
            res.add(li);
        }

        buildList(A, B, curr + 1);

    }
}

// Approach2-> Editorial

public class Solution {
    public int solve(int A, int B) {
        return solveQ(A, B) ? 1 : 0;
    }

    static boolean solveQ(int n, int k) {

        if (n == 1 && k == 1)
            return false;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid)
            return solveQ(n - 1, k);
        else
            return !solveQ(n - 1, k - mid);
    }
}