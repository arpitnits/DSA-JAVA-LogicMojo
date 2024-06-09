package HeapsAndPQ;

public class HeapSort {

    MaxHeap maxHeap;

    HeapSort() {
        maxHeap = new MaxHeap();
    }

    private void swap(int[] arr, int i,  int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSort(int[] arr, int n) {
        //buildMaxHeap
        int heapSize = n;

        while(heapSize>0) {
            swap(arr, 0, heapSize-1);
            heapSize--;
            maxHeap.heapifyDown(arr, heapSize, 0);
        }
    }
}
