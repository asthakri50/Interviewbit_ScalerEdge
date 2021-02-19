public class Solution {
    public int[] sortColors(int[] A) {
        int n = A.length;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            switch (A[i]) {
                case 0:
                    c0++;
                    break;
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;

            }
        }
        int i = 0;
        while (c0 > 0) {
            A[i] = 0;
            c0--;
            i++;
        }
        while (c1 > 0) {
            A[i] = 1;
            c1--;
            i++;
        }
        while (c2 > 0) {
            A[i] = 2;
            c2--;
            i++;
        }
        return A;
    }
}
//Time Complexity of this code is O(N)
//Space Complexity is O(1)

