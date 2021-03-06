vector<int> Solution::solve(const vector<int> &A, const vector<int> &B) {
    int n = A.size() , m = B.size() ; 
    vector<int> C(n+m) ; 
    //p1 & p2 are pointers on A , B  , and K is the pointer for the current index at C;
    int p1 = 0 , p2 = 0  , k = 0 ;
    while(p1 < n && p2 < m ){
        if(A[p1] < B[p2]){
            C[k] = A[p1] ;
            p1++ ; 
        }
        else{
            C[k]  = B[p2] ; 
            p2++ ; 
        }
        ++k ; 
    }
    
    //Copy the remaining elements of A
    while(p1 < n ){
        C[k] = A[p1] ; 
        ++k ; 
        ++p1 ; 
    }
    
    //Copy the remaining elements of B
    while(p2 < m ){
        C[k] = B[p2] ; 
        ++k ; 
        ++p2 ; 
    }
return C;    
}

