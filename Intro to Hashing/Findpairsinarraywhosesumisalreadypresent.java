public class Solution {
    public int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : A)
            hs.add(i);
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                // System.out.println(A[i] + A[j]) ;
                if (hs.contains(A[i] + A[j]))
                    count++;
            }
        }
        return count;
    }
}
