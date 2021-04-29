// Maximum XOR
// Problem Description

// Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.

// Problem Constraints
// 1 <= length of the array <= 100000
// 0 <= A[i] <= 109

// Input Format
// The only argument given is the integer array A.

// Output Format
// Return an integer denoting the maximum result of A[i] XOR A[j].

// Example Input
// Input 1:

//  A = [1, 2, 3, 4, 5]
// Input 2:

//  A = [5, 17, 100, 11]

// Example Output
// Output 1:

//  7
// Output 2:

//  117

// Example Explanation
// Explanation 1:

//  Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
// Explanation 2:

//  Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int decimalValue;

        TrieNode() {
            children = new TrieNode[2];
            isEnd = false;
            decimalValue = 0;
        }
    }

    public int solve(ArrayList<Integer> A) {

        TrieNode root = new TrieNode();

        insertInTrie(root, convertToBinary(A.get(0)), A.get(0));

        int max = 0;

        for (int i = 1; i < A.size(); i++) {
            TrieNode temp = root;
            ArrayList<Integer> li = convertToBinary(A.get(i));

            for (int j = 0; j < 32; j++) {
                int req = li.get(j) ^ 1;
                if (temp.children[req] == null) {
                    req = li.get(j);
                }
                temp = temp.children[req];
            }
            max = Math.max(max, A.get(i) ^ temp.decimalValue);
            insertInTrie(root, li, A.get(i));
        }
        return max;
    }

    public void insertInTrie(TrieNode root, ArrayList<Integer> binary, int value) {
        TrieNode temp = root;
        for (int i = 0; i < 32; i++) {
            int req = binary.get(i);
            if (temp.children[req] == null)
                temp.children[req] = new TrieNode();

            temp = temp.children[req];
        }
        temp.isEnd = true;
        temp.decimalValue = value;
    }

    public ArrayList<Integer> convertToBinary(int n) {
        ArrayList<Integer> res = new ArrayList<>();

        // Size of an integer is assumed to be 32 bits
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                res.add(1);
            else
                res.add(0);
        }
        return res;
    }

}
