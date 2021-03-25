// Problem Description

// Given an integer A, you have to find the Ath Perfect Number.

// A Perfect Number has the following properties:

// It comprises only 1 and 2.

// The number of digits in a Perfect number is even.

// It is a palindrome number.

// For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



// Problem Constraints
// 1 <= A <= 100000



// Input Format
// The only argument given is an integer A.



// Output Format
// Return a string that denotes the Ath Perfect Number.



// Example Input
// Input 1:

//  A = 2
// Input 2:

//  A = 3


// Example Output
// Output 1:

//  22
// Output 2:

//  1111


// Example Explanation
// Explanation 1:

// First four perfect numbers are:
// 1. 11
// 2. 22
// 3. 1111
// 4. 1221
// Explanation 2:

// First four perfect numbers are:
// 1. 11
// 2. 22
// 3. 1111
// 4. 1221


public class Solution {
    public String solve(int A) {
        Queue<String> q = new LinkedList<>() ;
        String[] ans = new String[A+1] ;
        q.add("1") ;
        q.add("2") ;
        for(int i = 1 ; i < A+1 ; i++){
            String s = q.peek() ;
            ans[i] = s ;
            q.add(s.concat("1") );
            q.add(s.concat("2") );
            q.remove() ;
        }
        return series(ans[A]) ;
    }
    
    public String series(String s){
        String ans = s ;
        String reverse = "" ;
        for(int i = s.length()-1 ; i >= 0; i--){
            reverse += s.charAt(i) ;
        }
    return ans.concat(reverse) ;    
    }
}
