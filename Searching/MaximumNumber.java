public class Solution {
    public int solve(int[] A, int B) {
        int N = A.length;
        int low = 1;
        int high = N;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public boolean check(int[] A, int B, int size_subarr) {
        int N = A.length;
        long max = 0;
        long sum = 0;
        for (int i = 0; i < size_subarr; i++)
            sum += A[i];

        max = Math.max(max, sum);

        for (int i = size_subarr; i < N; i++) {
            sum = (sum - A[i - size_subarr]) + A[i];
            max = Math.max(max, sum);
        }
        if (max <= B)
            return true;
        else
            return false;
    }

}
