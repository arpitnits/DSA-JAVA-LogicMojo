package Stack;

import java.util.Stack;

public class StockSpan {

    //[100, 80,110, 40, 120, 30]
    public static int[] stockSpan(int[] stock) {
        int n = stock.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i=0;i<n;i++) {

            while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? i+1 : i -stack.peek();
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] result = stockSpan(arr);
        for(int x: result)
            System.out.print(x + " ");
    }
}
