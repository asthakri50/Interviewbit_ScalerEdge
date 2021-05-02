// Repeat and Missing Number Array
// You are given a read only array of n integers from 1 to n.

// Each integer appears exactly once except A which appears twice and B which is missing.

// Return A and B.

// Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Note that in your output A should precede B.

// Example:

// Input:[3 1 2 5 3] 

// Output:[3, 4] 

// A = 3, B = 4

public class Solution {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public int[] repeatedNumber(final int[] a) {

        long rSum = 0, rSumSq = 0, aSum = 0, aSumSq = 0;

        for (int i = 0; i < a.length; i++) {

            aSum += a[i];

            rSum += (i + 1);

            aSumSq += (long) ((long) a[i] * (long) a[i]);

            rSumSq += (long) ((long) (i + 1) * (long) (i + 1));

        }

        long x = 0, y = 0, z = 0;

        y = (rSum - aSum);

        z = (rSumSq - aSumSq);

        if (y != 0)

            x = z / y;

        else
            x = 0;

        int res[] = new int[2];

        res[1] = (int) (x + y) / 2;

        res[0] = (int) (x - y) / 2;

        return res;

    }

}