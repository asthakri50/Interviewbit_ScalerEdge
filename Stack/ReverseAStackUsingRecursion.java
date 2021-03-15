public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> origin = new Stack<>();
      
        for(int i = A.size()-1 ; i >= 0 ; i--)
            origin.push(A.get(i) );
      
        reverse(origin) ;
      
        ArrayList<Integer> ans = new ArrayList<>();
      
        while(!origin.isEmpty() ){
            int y = origin.peek();
            ans.add(y);
            origin.pop();
        }
    return ans;    
    }
    
    public void reverse(Stack<Integer> origin){
        //Base Case
        if(origin.isEmpty() )
            return;
            
        int temp = origin.peek();
        origin.pop();
        reverse(origin);
        insertAtBottom(origin , temp);
    }
    
    public void insertAtBottom(Stack<Integer> origin , int x){
        //Base Case
        if(origin.isEmpty() ){
            origin.push(x) ;
            return ;
        }
        int help = origin.peek();
        origin.pop();
        insertAtBottom(origin , x);
        origin.push(help) ;
    }
}
