package Array;

public class Sorting {

    public static void swap(int[] nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++) {
                if(nums[j] > nums[j+1]) {
                    swapped = true;
                    swap(nums, j, j+1);
                }
            }
            if(!swapped)
                return;
        }
    }


    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            int min = i;
            for(int j=i+1;j<n;j++) {
                if(nums[j] < nums[min])
                    min = j;
            }
            swap(nums, i, min);
        }
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length, value, hole;
        for(int i=1;i<n;i++) {
            value = nums[i];
            hole = i-1;
            while(hole>=0 && nums[hole]>=value) {
                nums[hole+1] = nums[hole];
                hole--;
            }
            nums[hole+1] = value;
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,12,1,5,6,2};
        insertionSort(nums);

        for(int x: nums)
            System.out.print(x + " ");
    }
}
