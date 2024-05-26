package Strings;

import java.util.Stack;

public class FixBrackets {

    public int minSwaps(String str) {
        int n = str.length();
        Stack<Character> s = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch=='[') {
                s.add(ch);
            } else {
                if(!s.isEmpty() && s.peek()=='[') {
                    s.pop();
                } else {
                    s.add(ch);
                }
            }
        }
        double stackSize = s.size()/2.0;
        return (int)Math.ceil(stackSize/2.0);
    }

    //TC= O(N)
    public int minSwapsWithoutStack(String str) {
        int open=0, close=0;
        char lastChar='n';
        for(char ch : str.toCharArray()) {
            if(ch=='[') {
                open++;
                lastChar = '[';
            } else {
                if(lastChar=='[') {
                    open--;
                } else {
                    close++;
                    lastChar=']';
                }
            }
        }
        return (int)Math.ceil(open/2.0);
    }
}
