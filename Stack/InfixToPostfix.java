// Infix to Postfix
// Problem Description

// Given string A denoting an infix expression. Convert the infix expression into postfix expression.

// String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.

// Find and return the postfix expression of A.

// NOTE:

// ^ has highest precedence.
// / and * have equal precedence but greater than + and -.
// + and - have equal precedence and lowest precedence among given operators.


// Problem Constraints
// 1 <= length of the string <= 500000



// Input Format
// The only argument given is string A.



// Output Format
// Return a string denoting the postfix conversion of A.



// Example Input
// Input 1:

//  A = "x^y/(a*z)+b"
// Input 2:

//  A = "a+b*(c^d-e)^(f+g*h)-i"


// Example Output
// Output 1:

//  "xy^az*/b+"
// Output 2:

//  "abcd^e-fgh*+^*+i-"

public class Solution {
    public String solve(String A) {
        Stack<Character> stk = new Stack();
        StringBuilder postfix = new StringBuilder() ;
        
        for(int i = 0 ; i < A.length() ; i++){
            //If A[i] is a operand
            if(check_operand(A.charAt(i) ) )
                postfix.append( A.charAt(i) ) ;
            else if(A.charAt(i) == '(' )
                stk.push('(') ;    
            else if(A.charAt(i) == ')'){
                while(stk.peek() != '(' ){
                    postfix.append( stk.peek() ) ;
                    stk.pop();
                }
            stk.pop();    //Popping the opening bracket
            }
            else{        // If the character is an operator
                while(!stk.isEmpty() ){
                    if(stk.peek() == '(' || precedance(stk.peek() ) < precedance(A.charAt(i) ) ){
                        break ;
                    }
                    else{
                        postfix.append( stk.peek() ) ;
                        stk.pop() ;
                    }
                }
                stk.push(A.charAt(i) ) ;
            }
        }
        while(!stk.isEmpty() ){
            postfix.append( stk.peek() ) ;
            stk.pop();
        }
      return postfix.toString() ;  
    }
    
    public boolean check_operand(char ch){
        if(ch >= 'a' && ch <= 'z')
            return true ;
        return false;    
    }
    
    public int precedance(char ch){
        if(ch == '^')
            return 3;
        if(ch == '/' || ch == '*')
            return 2;
        else if(ch == '+' || ch == '-')
            return 1 ;
    return 0 ;        
    }
}

