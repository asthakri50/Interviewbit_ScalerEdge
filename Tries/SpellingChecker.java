// Spelling Checker
// Problem Description

// Given an array of words A (dictionary) and another array B (which contain some words).

// You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

// Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

// Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

// NOTE: Try to do this in O(n) time complexity.

// Problem Constraints
// 1 <= |A| <= 1000

// 1 <= sum of all strings in A <= 50000

// 1 <= |B| <= 1000

// Input Format
// First argument is array of strings A.

// First argument is array of strings B.

// Output Format
// Return the binary array of integers according to the given format.

// Example Input
// Input 1:

// A = [ "hat", "cat", "rat" ]
// B = [ "cat", "ball" ]
// Input 2:

// A = [ "tape", "bcci" ]
// B = [ "table", "cci" ]

// Example Output
// Output 1:

// [1, 0]
// Output 2:

// [0, 0]

// Example Explanation
// Explanation 1:

// Only "cat" is present in the dictionary.
// Explanation 2:

// None of the words are present in the dictionary.

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < A.size(); i++)
            insertInTrie(root, A.get(i));

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < B.size(); i++) {
            if (searchInTrie(root, B.get(i)))
                res.add(1);
            else
                res.add(0);
        }
        return res;
    }

    public void insertInTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            if (temp.children[str.charAt(i) - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                temp.children[str.charAt(i) - 'a'] = newNode;
            }
            temp = temp.children[str.charAt(i) - 'a'];
        }

        temp.isEnd = true;
        return;
    }

    boolean searchInTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            if (temp.children[str.charAt(i) - 'a'] == null)
                return false;
            else
                temp = temp.children[str.charAt(i) - 'a'];
        }
        if (temp.isEnd)
            return true;

        return false;
    }
}
