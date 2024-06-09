package HeapsAndPQ;

public class MaxHeap {


    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public void buildHeap(int[] arr) {
        //apply heapify
    }
    public void insert(int val) {
        //heapifyUp
    }

    public void remove() {
        //replace
        //heapifyDown
    }


    private void heapifyUp(int[] heap, int i) {
        int parent = (i-1)/2;
        if(parent>=0) {
            if(heap[parent] < heap[i]) {
                swap(heap, i, parent);
                heapifyUp(heap, parent);
            }
        }
    }

    public void heapifyDown(int[] heap, int heapSize, int i) {
        int left = 2*i+1, right = 2*i+2;
        int higher = i;
        if(left<heapSize && heap[left]>heap[higher])
            higher = left;
        if(right<heapSize && heap[right]>heap[higher])
            higher = right;

        if(higher!=i) {
            swap(heap, i, higher);
            heapifyDown(heap, heapSize, higher);
        }
    }
}
