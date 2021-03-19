// Check two bracket expressions
// Problem Description

// Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

// The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

// NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.



// Problem Constraints
// 1 <= length of the each String <= 100



// Input Format
// The arguments given are string A and String B.



// Output Format
// Return 1 if they represent the same expression else return 0.



// Example Input
// Input 1:

//  A = "-(a+b+c)"
//  B = "-a-b-c"
// Input 2:

//  A = "a-b-(c-d)"
//  B = "a-b-c-d"


// Example Output
// Output 1:

//  1
// Output 2:

//  0


// Example Explanation
// Explanation 1:

//  The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 
// Explanation 2:

//  Both the expression are different.

public class Solution {
    public int solve(String A, String B) {
        int[] a = new int[26] ;
        int[] b = new int[26] ;
        
        compute_Signs(A , a) ;
        compute_Signs(B , b) ;
        
        for(int i = 0 ; i < 26 ; i++){
            if(a[i] != b[i])
                return 0 ;
        }
        return 1 ;
    }
    
    public void compute_Signs(String str , int[] sign){
        Stack<Integer> stk = new Stack();
        stk.push(1);
        
        for(int i = 0 ; i < str.length() ; i++){
    
            if(str.charAt(i) == '(' ){
                if(i == 0){
                    stk.push(1) ;
                    continue ;
                }    
                if(str.charAt(i-1) == '-')
                    stk.push(-stk.peek() );
                else
                    stk.push(stk.peek() );
            }
            else if(str.charAt(i) == ')'){
                stk.pop();
            }
            else if(check_char(str.charAt(i) ) ){
                int global = stk.peek() ;
                int local = 1 ;
                if(i == 0){
                    local = 1 ;
                }
                else if(str.charAt(i-1) == '-' )
                    local = -1 ;
                sign[str.charAt(i) - 97] = local*global ;    
            }
        }
    }
    
    public boolean check_char(char ch){
        if(ch >= 'a' && ch <= 'z')
            return true ;
        return false ;    
    }
}
