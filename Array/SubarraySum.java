package Array;

public class SubarraySum {

    public static void allPositiveSubArray(int[] nums, int X) {
        int n = nums.length;
        int sum=0,l=0,r=0;
        while (l<=r) {
            sum= sum + nums[r];
            if(sum==X) {
                System.out.println("Got the subArray with L:" + l + " R:" + r);
                return;
            } else if(sum<X) {
                r++;
            } else {
                sum= sum - nums[l++];
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,1,1,2};
        allPositiveSubArray(nums, 4);
    }
}
