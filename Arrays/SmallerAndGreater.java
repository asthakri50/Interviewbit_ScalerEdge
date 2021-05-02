// Smaller and Greater
// You are given an Array A of size N.

// Find for how many elements, there is a strictly smaller element and a strictly greater element.



// Input Format

// Given only argument A an Array of Integers.
// Output Format

// Return an Integer X, i.e number of elements.
// Constraints

// 1 <= N <= 1e5
// 1 <= A[i] <= 1e6
// For Example

// Example Input:
//     A = [1, 2, 3]

// Example Output:
//     1

// Explanation:
//     only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.

public class Solution {
    public int solve(int[] A) {
      int smallest=Integer.MAX_VALUE;
      int greatest = Integer.MIN_VALUE;
      int ans=0;
      for(int i=0;i<A.length;i++){
          if(A[i]<smallest)
            smallest = A[i];
          if(A[i]>greatest)
            greatest = A[i];
      }
      for(int a:A)
        if(a>smallest && a<greatest)
            ans++;
       return ans;
    }
   
}


