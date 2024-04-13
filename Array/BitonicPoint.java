package Array;

public class BitonicPoint {

    public static int findBitonicPoint(int[] nums) {
        int n = nums.length;

        int l =0, r=n-1;

        while (l<=r) {
            if(l==r)
                return nums[l];
            else if(l==r-1) {
                Math.max(nums[l], nums[r]);
            } else {
                int mid = l+(r-l)/2;
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                    return nums[mid];
                else if(nums[mid] > nums[mid-1])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
            int[] nums = {12,7,4,2};
        System.out.println(findBitonicPoint(nums));


    }
}
