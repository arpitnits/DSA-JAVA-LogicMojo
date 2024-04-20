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

    public static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] leftSubarray = new int[n1];
        int[] rightSubarray = new int[n2];

        for(int i=0;i<n1;i++)
            leftSubarray[i] = nums[l+i];

        for(int i=0;i<n2;i++)
            rightSubarray[i] = nums[mid+1 + i];

        int i =0, j=0, arrIndex=l;
        for( ;i<n1 && j<n2; arrIndex++) {
            if(leftSubarray[i] < rightSubarray[j]) {
                nums[arrIndex] = leftSubarray[i];
                i++;
            } else {
                nums[arrIndex] = rightSubarray[j];
                j++;
            }
        }

        for( ;i<n1; arrIndex++) {
            nums[arrIndex] = leftSubarray[i];
            i++;
        }

        for( ;j<n2; arrIndex++) {
            nums[arrIndex] = rightSubarray[j];
            j++;
        }
    }

    public static void splitAndMerge(int[] nums, int l, int r) {
        if(l<r) {
            int mid = l+(r-l)/2;
            splitAndMerge(nums, l, mid); //O(1)
            splitAndMerge(nums, mid+1, r); //O(1)
            merge(nums, l, mid, r); //O(N)
        }
    }


    public static void mergeSort(int[] nums) {
        splitAndMerge(nums, 0 , nums.length-1);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivotVal = nums[r];
        int i=l, j=l-1;

        while(i<r) {
            if(nums[i]<pivotVal) {
                j++;
                swap(nums, i, j);
            }
            i++;
        }
        j++;
        swap(nums, i, j);
        return j;
    }

    public static void partitionAndSort(int[] nums, int l, int r) {
        if(l<r) {
            int pivotIndex = partition(nums, l, r);
            partitionAndSort(nums, l, pivotIndex-1);
            partitionAndSort(nums, pivotIndex+1, r);
        }
    }

    public static void quickSort(int[] nums) {
        partitionAndSort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {5,12,1,5,6,2};
        quickSort(nums);

        for(int x: nums)
            System.out.print(x + " ");
    }
}
