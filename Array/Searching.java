package Array;

public class Searching {

    public static void linearSearch(int[] arr, int target) {
        //TC: O(N)
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==target) {
                System.out.println("Element found at Index: " + i);
                return;
            }
        }
        System.out.println("Element doesn't exist");
    }

    public static void binarySearch(int[] arr, int target) {
        int l =0, r=arr.length-1;
        int mid;
        while(l<=r) {
            mid = (l+r)/2;
            if(arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return;
            } else if(arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.println("Element not found");
    }


    public static void binarySearchRec(int[] arr, int l, int r, int target) {
        if(r<l)    return;
        int mid = (l+r)/2;
        if(arr[mid] == target) {
            System.out.println("Element found at index: " + mid);
            return;
        } else if(arr[mid] < target) {
            binarySearchRec(arr, mid+1, r, target);
        } else {
            binarySearchRec(arr, l, mid-1, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,9,10};
        binarySearchRec(arr, 0, arr.length-1, 3);
    }
}
