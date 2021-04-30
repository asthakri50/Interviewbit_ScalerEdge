// Minimize Difference
// Problem Description

// Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.

// You can perform two types of operations at most B times in total to change the values in the array.
// Multiple operations can be performed on the same element.

// Increment : A[i] -> A[i] + 1.

// Decrement : A[i] -> A[i] - 1.

// Return the minimum difference possible.

// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= 106

// 1 <= B <= 109

// Input Format
// First argument is an integer array A.
// Second argument is an integer B which represents the maximum number of operations that can be performed.

// Output Format
// Return an integer denoting the minimum difference.

// Example Input
// Input 1:

//  A = [2, 6, 3, 9, 8]
//  B = 3
// Input 2:

//  A = [4, 6, 3, 1, 4]
//  B = 5

// Example Output
// Output 1:

//  5
// Output 2:

//  1

// Example Explanation
// Explanation 1:

//  We can apply the atmost 3 operations in the following sequence.
//  Initial array => [2, 6, 3, 9, 8].
//    Decrement 9 => [2, 6, 3, 8, 8].
//    Increment 2 => [3, 6, 3, 8, 8].
//    Increment 3 => [3, 6, 4, 8, 8].
//  Max = 8. Min = 3.
//  Therefore, abs|Max - Min| = |8 - 3| = 5.
// Explanation 2:

//  We can apply the atmost 5 operations in the following sequence.
//  Initial array => [4, 6, 3, 1, 4].
//    Increment 1 => [4, 6, 3, 2, 4].
//    Decrement 6 => [4, 5, 3, 2, 4].
//    Increment 2 => [4, 5, 3, 3, 4].
//    Decrement 5 => [4, 4, 3, 3, 4].
//    Increment 3 => [4, 4, 4, 3, 4].
//  Max = 4. Min = 3.
//  Therefore, abs|Max - Min| = |4 - 3| = 1.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (!map.containsKey(num))
                map.put(num, 1);
            else {
                int f = map.get(num);
                map.put(num, f + 1);
            }
        }

        // System.out.println(max +" " + min);

        while (min < max && B > 0) {
            int f1 = map.get(min);
            int f2 = map.get(max);
            // System.out.println(min+":"+f1 +" " + max+":"+f2) ;
            // increment is suitable
            if (f1 < f2) {
                if (f1 > B)
                    break;
                else {
                    // freq[min + 1] = freq[min+1] + freq[min] ;
                    if (map.containsKey(min + 1))
                        map.put(min + 1, map.get(min + 1) + map.get(min));

                    else
                        map.put(min + 1, map.get(min));
                    // System.out.println("Increamenting " + min ) ;

                    B = B - f1;
                    min = min + 1;
                }

            }
            // decreament is suitable
            else {
                if (f2 > B)
                    break;
                else {
                    // freq[max - 1] = freq[max - 1] + freq[max] ;
                    if (map.containsKey(max - 1))
                        map.put(max - 1, map.get(max - 1) + map.get(max));
                    else
                        map.put(max - 1, map.get(max));
                    // System.out.println("Dreamenting "+ max ) ;
                    B = B - f2;
                    max = max - 1;
                }
            }

        }
        // System.out.println(max + " " + min) ;

        return max - min;
    }
}
