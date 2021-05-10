// Same Format String
// Problem Description

// Given two strings A and B. Check if B contains same characters as that of given string A and in the same order.

// Problem Constraints
// 1: A and B contain only UPPERCASE Letters.
// 2: No two consecutive characters are same in A.
// 3: You can only use constant amount of extra memory.

// Input Format
// The first argument given is string A.
// The second argument given is string B.

// Output Format
// Return 1 if B contains same characters as that of given string A and in the same order else return 0.

// Example Input
// Input 1:
//     A = "HIRED" 
//     B = "HHHIIIRRRRREEEEEDDDDD"
// Input 2:

//     A = "HIRED"
//     B = "DDHHHHIIIIRRRRREEEEDDD"

// Example Output
// Output 1:
//     1
// Output 2:

//     0

// Example Explanation
// Explanation 1:
//     B has same characters and appear in same order.
// Explanation 2:

//     B has extra character "D"

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final String A, final String B) {
        int count = 0;
        char ch = B.charAt(0);
        char x = A.charAt(0);
        if (ch != x)
            return 0;

        count = count + 1;
        int i;
        for (i = 1; i < B.length(); i++) {
            ch = B.charAt(i);

            if (count < A.length())
                x = A.charAt(count);

            char y = B.charAt(i - 1);

            if (ch != x && ch != y)
                return 0;

            if (count < A.length() && ch == x)
                count++;

            // When A's characterts are finished first and B has some characters left .
            if (count > A.length() && ch != y)
                return 0;
        }

        // When B's characters are finished first and A has some characters left .
        if (count < A.length())
            return 0;

        return 1;
    }
}

// Implementation 2->
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final String A, final String B) {
        int i = 0, j = 0;
        int n = A.length();
        int m = B.length();

        while (i < n) {
            int count = 0;

            // count how many times the current character is available in string B

            while (j < m && B.charAt(j) == A.charAt(i)) {
                count++;
                j++;
            }

            // if count does not greater than one, return unmatched

            if (count == 0)
                return 0;

            i++;
        }

        // here we are checking whether the strings have been completely used up or not
        if (i != n || j != m)
            return 0;

        return 1;
    }
}
