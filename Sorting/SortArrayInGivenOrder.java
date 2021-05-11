// Sort Array in given Order
// Problem Description

// Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

// Return the array A after sorting from the above method.

// NOTE: Elements of B are unique.

// Problem Constraints
// 1 <= length of the array A <= 100000

// 1 <= length of the array B <= 100000

// -10^9 <= A[i] <= 10^9

// Input Format
// The first argument given is the integer array A.

// The second argument given is the integer array B.

// Output Format
// Return the array A after sorting as described.

// Example Input
// Input 1:

// A = [1, 2, 3, 4, 5]
// B = [5, 4, 2]
// Input 2:

// A = [5, 17, 100, 11]
// B = [1, 100]

// Example Output
// Output 1:

// [5, 4, 2, 1, 3]
// Output 2:

// [100, 5, 11, 17]

// Example Explanation
// Explanation 1:

//  Simply sort as described.
// Explanation 2:

//  Simply sort as described.

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (!map.containsKey(A.get(i)))
                map.put(A.get(i), 1);
            else {
                int num = map.get(A.get(i));
                map.put(A.get(i), num + 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < B.size(); i++) {
            if (map.containsKey(B.get(i))) {
                int freq = map.get(B.get(i));
                while (freq > 0) {
                    res.add(B.get(i));
                    freq--;
                }
                map.remove(B.get(i));
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int key : map.keySet()) {
            int freq = map.get(key);

            while (freq > 0) {
                temp.add(key);
                freq--;
            }

        }

        Collections.sort(temp);

        for (int i = 0; i < temp.size(); i++)
            res.add(temp.get(i));

        return res;

    }
}
