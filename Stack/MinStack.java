import java.io.*;
import java.util.*;

class MinStack {
    Stack<Integer> origin = new Stack();
    Stack<Integer> min_stk = new Stack();

    public void push(int x) {
        if (origin.isEmpty()) {
            origin.push(x);
            min_stk.push(x);
        } else {
            origin.push(x);
            if (x <= (min_stk.peek()))
                min_stk.push(x);
            else
                min_stk.push(min_stk.peek());
        }
    }

    public void pop() {
        if (origin.isEmpty())
            return;

        origin.pop();

        min_stk.pop();
    }

    public int top() {
        if (origin.isEmpty())
            return -1;

        return origin.peek();
    }

    public int getMin() {
        if (min_stk.isEmpty())
            return -1;
        return min_stk.peek();
    }
}
