package Stack;

import java.util.Stack;

public class InfixToPostFix {

    public int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

        }
        return -1;
    }

    public boolean isOperand(char ch) {
        return (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }


    public String infixToPostfix(String infix) {

        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //operand -> Opening bracket -> closing -> operator
        for(char ch : infix.toCharArray()) {
            if(isOperand(ch)) {
                postFix.append(ch);
            } else if(ch=='(') {
                stack.push('(');
            } else if(ch==')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    postFix.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(stack.peek())>=priority(ch)) {
                    postFix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }

        return postFix.toString();
    }
}
