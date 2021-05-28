// Problem Description

// Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

// Each number in A may only be used once in the combination.

// Note:

// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// Warning:

// DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

// Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.

// Problem Constraints
// 1 <= N <= 20

// Input Format
// First argument is an integer array A denoting the collection of candidate numbers.
// Second argument is an integer which represents the target number.

// Output Format
// Return all unique combinations in A where the candidate numbers sums to B.

// Example Input
// Input 1:

//  A = [10, 1, 2, 7, 6, 1, 5]
//  B = 8
// Input 2:

//  A = [2, 1, 3]
//  B = 3

// Example Output
// Output 1:

//  [ 
//   [1, 1, 6 ],
//   [1, 2, 5 ],
//   [1, 7 ], 
//   [2, 6 ] 
//  ]
// Output 2:

//  [
//   [1, 2 ],
//   [3 ]
//  ]

// Example Explanation
// Explanation 1:

//  1 + 1 + 6 = 8
//  1 + 2 + 5 = 8
//  1 + 7 = 8
//  2 + 6 = 8
//  All the above combinations sum to 8 and are arranged in ascending order.
// Explanation 2:

//  1 + 2 = 3
//  3 = 3
//  All the above combinations sum to 3 and are arranged in ascending order.

public class Solution {
    HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<Integer> li = new ArrayList<Integer>();
        int n = A.size();
        int val = printAll(0, B, A, n, li);

        return (new ArrayList(res));
    }

    public int printAll(int index, int B, ArrayList<Integer> A, int n, ArrayList<Integer> li) {
        if (B == 0) {
            res.add(li);
            return 1;
        }

        if (index == n)
            return 0;

        // not choosingA[index]
        int ans2 = printAll(index + 1, B, A, n, li);

        // choosing A[index]
        li = new ArrayList<Integer>(li);
        li.add(A.get(index));
        int ans1 = printAll(index + 1, B - A.get(index), A, n, li);

        return (ans1 + ans2);
    }
}
