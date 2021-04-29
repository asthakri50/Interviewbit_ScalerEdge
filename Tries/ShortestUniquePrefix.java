// Shortest Unique Prefix
// Problem Description

// Given a list of N words. Find shortest unique prefix to represent each word in the list.

// NOTE: Assume that no word is prefix of another. In other words, the representation is always possible

// Problem Constraints
// 1 <= Sum of length of all words <= 106

// Input Format
// First and only argument is a string array of size N.

// Output Format
// Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

// Example Input
// Input 1:

//  A = ["zebra", "dog", "duck", "dove"]
// Input 2:

// A = ["apple", "ball", "cat"]

// Example Output
// Output 1:

//  ["z", "dog", "du", "dov"]
// Output 2:

//  ["a", "b", "c"]

// Example Explanation
// Explanation 1:

//  Shortest unique prefix of each word is:
//  For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
//  For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
//  For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
//  For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  

// Explanation 2:

//  "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.

public class Solution {

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int count;

        // Constructor
        TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++)
                children[i] = null;

            isEnd = false;
            count = 1;
        }
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < A.size(); i++)
            insertInTrie(root, A.get(i));

        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < A.size(); i++) {
            res.add(findPrefix(root, A.get(i)));
        }

        return res;
    }

    public void insertInTrie(TrieNode root, String str) {
        TrieNode temp = root;

        for (int i = 0; i < str.length(); i++) {
            if (temp.children[str.charAt(i) - 'a'] == null) {
                temp.children[str.charAt(i) - 'a'] = new TrieNode();
            } else {
                temp.children[str.charAt(i) - 'a'].count++;
            }
            temp = temp.children[str.charAt(i) - 'a'];
            // System.out.println(str.charAt(i) +" "+ temp.count ) ;
        }
        temp.isEnd = true;
    }

    public String findPrefix(TrieNode root, String str) {
        StringBuffer string = new StringBuffer();
        TrieNode temp = root;
        int i;
        for (i = 0; i < str.length(); i++) {
            temp = temp.children[str.charAt(i) - 'a'];

            // System.out.println(str.charAt(i)+" "+ temp.count) ;
            if (temp == null)
                return string.toString();

            if (temp.count == 1) {
                string.append(str.charAt(i));
                break;
            }
            string.append(str.charAt(i));

        }
        return string.toString();
    }
}
