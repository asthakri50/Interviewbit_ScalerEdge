// Reverse the String
// Problem Description

// Given a string A of size N.

// Return the string A after reversing the string word by word.

// NOTE:

// A sequence of non-space characters constitutes a word.
// Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
// If there are multiple spaces between words, reduce them to a single space in the reversed string.

// Problem Constraints
// 1 <= N <= 3 * 105

// Input Format
// The only argument given is string A.

// Output Format
// Return the string A after reversing the string word by word.

// Example Input
// Input 1:
//     A = "the sky is blue"
// Input 2:
//     A = "this is ib"  

// Example Output
// Output 1:
//     "blue is sky the"
// Output 2:
//     "ib is this"    

// Example Explanation
// Explanation 1:
//     We reverse the string word by word so the string becomes "the sky is blue".
// Explanation 2:
//     We reverse the string word by word so the string becomes "this is ib".

public class Solution {
    public String solve(String A) {
        if (A.length() == 1)
            return A;

        String rev = reverse(A);

        String[] str = rev.split("\\s+");

        // for(int i = 0 ; i < str.length ; i++)
        // System.out.println(str[i]) ;

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            str[i] = reverse(str[i]);
            ans.append(str[i]);

            if (i != str.length - 1)
                ans.append(" ");
        }
        return ans.toString().trim();
    }

    public String reverse(String A) {
        int n = A.length();
        StringBuilder temp = new StringBuilder(A);
        for (int i = 0; i < n / 2; i++) {
            char ch = temp.charAt(i);
            char charac = temp.charAt(n - 1 - i);

            temp.setCharAt(i, charac);
            temp.setCharAt(n - 1 - i, ch);

        }

        return temp.toString();
    }
}

// Approach2 :-
public class Solution {
    public String solve(String A) {
        String[] str = A.split("\\s+");
        int n = str.length;

        for (int i = 0; i < n / 2; i++) {
            String temp = str[i];
            str[i] = str[n - 1 - i];
            str[n - 1 - i] = temp;
        }

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            ans.append(str[i]);
            ans.append(" ");
        }

        return ans.toString().trim();
    }
}