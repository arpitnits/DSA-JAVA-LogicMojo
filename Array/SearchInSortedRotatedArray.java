package Array;

public class SearchInSortedRotatedArray {

    public static int findPivot(int[] nums) {
        int n = nums.length;
        int l=0, r=n-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid]>nums[l])  l=mid+1;
            else    r=mid-1;
        }
        System.out.println("not able to find pivot");
        return -1;
    }

    public static int binarySearch(int[] arr, int target, int l, int r) {
        int mid;
        while(l<=r) {
            mid = (l+r)/2;
            if(arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return mid;
            } else if(arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if(nums[0]<= nums[nums.length-1]) {
            //already sorted
            return binarySearch(nums, target, 0, nums.length-1);
        }

        int pivotIndex = findPivot(nums);

        if(target>=nums[0])
            return binarySearch(nums, target, 0, pivotIndex);

        return binarySearch(nums, target, pivotIndex, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,3};
        search(nums, 2);
    }
}
