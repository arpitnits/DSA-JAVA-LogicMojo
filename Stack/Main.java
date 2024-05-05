package Stack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Implementation.ArrayImpl arrayImp = new Implementation.ArrayImpl();
        arrayImp.push(2);
        arrayImp.push(3);
        System.out.println("top=" + arrayImp.top());
        System.out.println("pop=" + arrayImp.pop());
        System.out.println("top=" + arrayImp.top());
    }
}
