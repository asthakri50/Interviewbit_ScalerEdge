public class Solution {
    public int books(int[] A, int B) {
        int N = A.length ; 
        
        if(N < B)
            return -1 ;
       //low = maximum element in the array
        //high = sum of all the elements in the array
        int low = 0 ;
        int high = 0 ;
        for(int i = 0 ; i < N ; i++){
            if(A[i] > low)
                low = A[i] ;
            high = high + A[i] ;    
        }
        
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(check( A , mid , B) ){
              ans = mid ; 
              high = mid - 1 ;
            }
            else
             low = mid + 1 ;
        }
    return ans ;    
    }
    
    public boolean check(int[] A , int max_page , int B){
        int N = A.length ;
        int num_students = 1 ;
        int sum = 0 ;
        
        for(int i = 0 ; i < N ; i++){
            sum = sum + A[i] ;
            //When I need a new student
            if(sum > max_page){
                num_students++ ;
                sum = A[i] ;
            }
        }
        //When we can say that books has been allocated with minimum max_pages 
        if(num_students <= B)
        return true ;
        
        return false ;
    }
    
}
