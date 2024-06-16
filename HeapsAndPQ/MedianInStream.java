package HeapsAndPQ;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
    PriorityQueue<Integer> right = new PriorityQueue<>(); //minHeap

    public void addNum(int num) {
        if(left.size()==0 || num<left.peek())
            left.add(num);
        else
            right.add(num);

        //reBalancing
        if(left.size() -right.size() >1) {
            right.add(left.remove());
        } else if(right.size() -left.size() >1){
            left.add(right.remove());
        }
    }

    public double findMedian() {
        if(left.size()==0)  return -1;

        if(left.size() > right.size()) {
           return left.peek();
        } else if(right.size() > left.size()){
            return right.peek();
        } else {
            return (left.peek() + right.peek())*1.0 / 2.0;
        }
    }

    //for removal -> find element and remove
}
