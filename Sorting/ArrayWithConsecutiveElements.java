import java.util.Arrays;
public class ArrayWithConsecutiveElements {
    public int solve(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] != 1)
                return 0;
        }
        return 1;
    }

}
