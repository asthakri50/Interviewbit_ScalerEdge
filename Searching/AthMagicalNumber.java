public class Solution {

    long gcd(long a,long b){

        if (b == 0) 

        {return a;} 

      return gcd(b, a % b); 

    }

    public int solve(int A, int B, int C) {

        long b=B;

        long c=C;

        long a=A;

        long low=0;

        

        long hcf=gcd(c,b);

        

        long lcm=b*c/(hcf);

        // System.out.println(lcm);

        long high=Long.MAX_VALUE;

        long ans = 0;

        while(low<=high){

            long mid=low+(high-low)/2;

            

            long count=(mid/b)+(mid/c)-(mid/lcm);

            if(count>=A){

                ans = mid;

                high = mid - 1;
            }

            else{

                low=mid+1;

            }

        }

        return (int)(ans%1000000007);

    }

}