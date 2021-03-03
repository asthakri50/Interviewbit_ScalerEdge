public class Solution {

    static int mod=1000000007;

    public int solve(int[] A, int B) {

        int l=A.length;

        int i=0,j=l-1;

         long sum=0;

         long count=0;

         long one = 1L;

        int ci=1,cj=1;

        while(i<j)

        {   sum=one*A[i]+A[j];

            if(sum>B){ //  System.out.println(i+" contract "+j);

                j--;

            }

            else if(sum<B) {   

                i++;//System.out.println(i+" expansion "+j);

            }

            else if(sum==B && A[i]!=A[j])

            {   if(A[i]!=A[i+1]&&A[j]!=A[j-1])

                {

                        count+=one*ci*cj;

                        count=count%mod;

                        ci=1;cj=1;

                        i++;j--;

                    

                }

                else{

                        if(A[i]==A[i+1]){ci++;i++;}

                        if(A[j]==A[j-1]){cj++;j--;}

                }

                

            }

            else if(sum==B && A[i]==A[j])

            {

                int z=j-i+1;

                count+=one*z*(z-1)/2;

                count=count%mod;

                break;

            }

            //System.out.println(i+" "+j);

        }

        return (int)count;

    }

}