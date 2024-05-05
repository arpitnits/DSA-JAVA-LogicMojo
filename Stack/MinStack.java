package Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    int min = -1;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if(s.isEmpty()) {
            min = val;
            s.push(val);
        } else if(val<= min) {
            s.push(2*val - min);
            min = val;
        } else {
            s.push(val);
        }
    }

    public void pop() {
        if(s.isEmpty())     return;
        int val = s.pop();
        if(val<=min) {
            min = 2*min - val;
        }
    }

    public int top() {
        if(s.isEmpty())     return -1;

        int val = s.peek();
        if(val<=min) {
            return min;
        }
        return val;
    }

    public int getMin() {
        return min;
    }
}
