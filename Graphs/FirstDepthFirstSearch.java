/*
 * First Depth First Search Problem Description
 * 
 * You are given N towns (1 to N). All towns are connected via unique directed
 * path as mentioned in the input.
 * 
 * Given 2 towns find whether you can reach the first town from the second
 * without repeating any edge.
 * 
 * B C : query to find whether B is reachable from C.
 * 
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B,
 * C <= N ).
 * 
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's
 * guaranteed that A[i] <= i.
 * 
 * NOTE: Array A is 0-indexed.
 * 
 * 
 * 
 * Problem Constraints 1 <= n <= 100000
 * 
 * 
 * 
 * Input Format First argument is vector A
 * 
 * Second argument is integer B
 * 
 * Third argument is integer C
 * 
 * 
 * 
 * Output Format Return 1 if reachable, 0 otherwise.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 1, 2] B = 1 C = 2 Input 2:
 * 
 * A = [1, 1, 2] B = 2 C = 1
 * 
 * 
 * Example Output Output 1:
 * 
 * 0 Output 2:
 * 
 * 1
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Tree is 1--> 2--> 3 and hence 1 is not reachable from 2. Explanation 2:
 * 
 * Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 * 
 */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int N = A.size();

        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 1; i < N; i++)
            adj.get(A.get(i)).add(i + 1);

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        dfs(C, adj, visited);

        if (visited[B] == true)
            return 1;

        return 0;
    }

    private void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[start] = true;

        for (Integer num : adj.get(start)) {
            if (visited[num] == false)
                dfs(num, adj, visited);
        }

        return;
    }
}
