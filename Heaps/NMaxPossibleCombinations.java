// N max pair combinations
// Problem Description

// Given two integers arrays A and B of size N each.

// Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

// Problem Constraints
// 1 <= N <= 2 * 105

// -1000 <= A[i], B[i] <= 1000

// Input Format
// First argument is an integer array A.
// Second argument is an integer array B.

// Output Format
// Return an intger array denoting the N maximum element in descending order.

// Example Input
// Input 1:

//  A = [1, 4, 2, 3]
//  B = [2, 5, 1, 6]
// Input 2:

//  A = [2, 4, 1, 1]
//  B = [-2, -3, 2, 4]

// Example Output
// Output 1:

//  [10, 9, 9, 8]
// Output 2:

//  [8, 6, 6, 5]

// Example Explanation
// Explanation 1:

//  4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
// Explanation 2:

//  4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        int len = a.size();
        ArrayList<Integer> al = new ArrayList<>(len);
        if (len == 0)
            return al;
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());
        HashSet<List<Integer>> pairs = new HashSet<>();
        pairs.add(Arrays.asList(0, 0));
        Queue<List<Integer>> heap = new PriorityQueue<>(len, (x, y) -> Integer.compare(y.get(0), x.get(0)));
        heap.add(Arrays.asList(a.get(0) + b.get(0), 0, 0));
        while (al.size() < len) {
            List<Integer> l = heap.poll();
            al.add(l.get(0));
            int i = l.get(1), j = l.get(2);
            List<Integer> pair = Arrays.asList(i + 1, j);
            if (i + 1 < len && !pairs.contains(pair)) {
                heap.add(Arrays.asList(a.get(i + 1) + b.get(j), i + 1, j));
                pairs.add(pair);
            }
            pair = Arrays.asList(i, j + 1);
            if (j + 1 < len && !pairs.contains(pair)) {
                heap.add(Arrays.asList(a.get(i) + b.get(j + 1), i, j + 1));
                pairs.add(pair);
            }
        }
        return al;
    }
}