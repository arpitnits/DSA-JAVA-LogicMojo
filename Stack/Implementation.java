package Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Implementation {

    static class ArrayImpl {
        int[] arr = new int[10000];
        int top = -1;

        void push(int x) {
            arr[++top] = x;
        }

        int pop() {
            return arr[top--];
        }

        int top() {
            return arr[top];
        }

        boolean isEmpty() {
            return top == -1;
        }

        int size() {
            return top+1;
        }
    }

    static class LinkedListImpl {

        void push(int x) {

        }

        int pop() {
            return 0;
        }

        int top() {
            return 0;
        }

        boolean isEmpty() {
            return false;
        }

        int size() {
            return 0;
        }
    }

    static class QueueImpl {

        Queue<Integer> q = new ArrayDeque<>();

        public void push(int val) {
            q.add(val);
            int size = q.size();

            for(int i=0;i<size-1;i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }
    }
}
