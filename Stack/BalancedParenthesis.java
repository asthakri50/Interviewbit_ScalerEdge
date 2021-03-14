public class Solution {
    public int solve(String A) {
        Stack<Character> open_stack = new Stack();
        Stack<Character> close_stack = new Stack();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '[')
                open_stack.push(A.charAt(i));
            else if (A.charAt(i) == '{')
                open_stack.push(A.charAt(i));
            else if (A.charAt(i) == '(')
                open_stack.push(A.charAt(i));

            if (A.charAt(i) == ')') {
                if (!open_stack.isEmpty() && open_stack.peek() == '(')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            } else if (A.charAt(i) == '}') {
                if (!open_stack.isEmpty() && open_stack.peek() == '{')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            } else if (A.charAt(i) == ']') {
                if (!open_stack.isEmpty() && open_stack.peek() == '[')
                    open_stack.pop();
                else
                    close_stack.push(A.charAt(i));
            }
        }
        if (open_stack.isEmpty() && close_stack.isEmpty())
            return 1;

        return 0;

    }
}
