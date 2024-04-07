package Array;

public class Segeregate0And1 {

    public static int[] swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {0,0,0,0,0,0};



        int l=0, r=arr.length-1;

        while(l<r) {

            while(l<r && arr[l]==0) l++;
            while(l<r && arr[r]==1) r--;

            if(l<r) {
                int c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
                l++;
                r--;
            }
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
