package Queue;

public class Implementation {
    int capacity = 5;
    int queueSize=0;
    int[] arr = new int[capacity];

    int front=0, rear=-1;

    public void enqueue(int val) {
        if(queueSize==capacity) {
            System.out.println("Already full");
        } else {
            rear = (rear+1)%capacity;
            arr[rear] = val;
            queueSize++;
        }
    }

    public int dequeue() {
        if(queueSize==0) {
            System.out.println("Already empty!");
            return -1;
        } else {
            int x = arr[front];
            front = (front+1)%capacity;
            queueSize--;
            return x;
        }
    }

    public int front() {
        if(queueSize==0) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return arr[front];
        }
    }

    public int rear() {
        if(queueSize==0) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return arr[rear];
        }
    }
}
