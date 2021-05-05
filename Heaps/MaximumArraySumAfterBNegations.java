// Problem Description

// Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

// You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

// Problem Constraints
// 1 <= length of the array <= 5*105
// 1 <= B <= 5 * 106
// -100 <= A[i] <= 100

// Input Format
// First argument given is an integer array A.
// Second argument given is an integer B.

// Output Format
// Return an integer denoting the maximum array sum after B modifications.

// Example Input
// Input 1:

//  A = [24, -68, -29, -9, 84]
//  B = 4
// Input 2:

//  A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
//  B = 10

// Example Output
// Output 1:

//  196
// Output 2:

//  362

// Example Explanation
// Explanation 1:

//  Final array after B modifications = [24, 68, 29, -9, 84]
// Explanation 2:

//  Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        // Maintain a heap Min
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < A.size(); i++)
            pq.add(A.get(i));

        for (int i = 0; i < B; i++) {
            int min = pq.poll();
            pq.add(min * -1);
        }

        int sum = 0;
        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}
