// Problem Description

// Given a string A denoting a stream of lowercase alphabets.

// You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.

// Problem Constraints
// 1 <= |A| <= 100000

// Input Format
// The only argument given is string A.

// Output Format
// Return a string B after processing the stream of lowercase alphabets A.

// Example Input
// Input 1:

//  A = "abadbc"
// Input 2:

//  A = "abcabc"

// Example Output
// Output 1:

// "aabbdd"
// Output 2:

// "aaabc#"

// Example Explanation
// Explanation 1:

// "a"      -   first non repeating character 'a'
// "ab"     -   first non repeating character 'a'
// "aba"    -   first non repeating character 'b'
// "abad"   -   first non repeating character 'b'
// "abadb"  -   first non repeating character 'd'
// "abadbc" -   first non repeating character 'd'
// Explanation 2:

// "a"      -   first non repeating character 'a'
// "ab"     -   first non repeating character 'a'
// "abc"    -   first non repeating character 'a'
// "abca"   -   first non repeating character 'b'
// "abcab"  -   first non repeating character 'c'
// "abcabc" -   no non repeating character so '#'

public class Solution {
    public String solve(String A) {
        char[] ans = new char[A.length()];
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] == 1)
                q.add(ch);

            while (!q.isEmpty()) {
                if (freq[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    ans[i] = q.peek();
                    break;
                }
            }
            if (q.isEmpty())
                ans[i] = '#';

        }

        return toString(ans);
    }

    public String toString(char[] a) {
        String string = new String(a);
        return string;
    }

}
