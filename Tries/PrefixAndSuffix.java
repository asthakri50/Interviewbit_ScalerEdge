// Prefix and Suffix
// Problem Description

// Given a list of N words denoted by string array A of size N.

// You have to answer Q queries denoted by string array B, for each query you have a string S of size M, find the number of words in the list A which have string S as a prefix and suffix.

// NOTE: The size M for all strings in the queries remains same.

// Problem Constraints
// 1 <= N <= 105

// 1 <= |A[i]| <= 1000

// 1 <= Q, M <= 1000

// Sum of length of all N words <= 106

// Input Format
// First argument is a string array A of size N denoting the list of words.

// Second argument is a string array B of size Q denoting the queries.

// Output Format
// Return an integer array of size Q denoting the answer of each query.

// Example Input
// Input 1:

//  A = ["ababa", "aabbvaab", "aecdsaaec", "abaaxbqaba"]
//  B = ["aba", "aec", "abb", "aab"]
// Input 2:

//  A = ["cazqzqcaz", "cadssac", "caz"]
//  B = ["caz", "cad"]

// Example Output
// Output 1:

//  [2, 1, 0, 1]
// Output 2:

//  [2, 0]

// Example Explanation
// Explanation 1:

//  2 word "ababa" and "abaaxbqaba" has both prefix and suffix "aba".
//  1 word "aecdsaaec" has both prefix and suffix "aec".
//  No word has both prefix and suffix "abb".
//  1 word "aabbvaab" has both prefix and suffix "aab".
// Explanation 2:

//  2 word "cazqzqcaz" and "caz" has both prefix and suffix "caz".
//  No word has both prefix and suffix "cad".

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            count = 1;
        }
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < A.size(); i++)
            insertInTrie(root, A.get(i));

        ArrayList<Integer> res = new ArrayList<Integer>();

        int[] prefixCount = new int[B.size()];
        int[] suffixCount = new int[B.size()];

        for (int i = 0; i < B.size(); i++)
            prefixCount[i] = findCount(root, B.get(i));

        // This is for testing prefixCount ;
        // for(int i = 0 ; i < B.size() ; i++)
        // System.out.print(prefixCount[i] +" ");

        for (int i = 0; i < A.size(); i++)
            A.set(i, reverse(A.get(i)));

        TrieNode newRoot = new TrieNode();
        for (int i = 0; i < A.size(); i++)
            insertInTrie(newRoot, A.get(i));

        for (int j = 0; j < B.size(); j++)
            B.set(j, reverse(B.get(j)));

        for (int i = 0; i < B.size(); i++)
            suffixCount[i] = findCount(newRoot, B.get(i));

        // This is for testing suffixCount ;
        // for(int i = 0 ; i < B.size() ; i++)
        // System.out.print(suffixCount[i] +" ");

        for (int i = 0; i < B.size(); i++)
            res.add(Math.min(prefixCount[i], suffixCount[i]));

        return res;
    }

    public void insertInTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if (temp.children[idx] == null)
                temp.children[idx] = new TrieNode();
            else
                temp.children[idx].count++;

            // MOVE TO NEXT NODE
            temp = temp.children[idx];
        }
        temp.isEnd = true;
    }

    public int findCount(TrieNode root, String str) {
        TrieNode temp = root;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (temp.children[idx] == null)
                return 0;
            else
                temp = temp.children[idx];
        }
        return temp.count;
    }

    public String reverse(String str) {
        StringBuffer reverse = new StringBuffer();
        int n = str.length();

        for (int i = n - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }

        return reverse.toString();
    }

}
