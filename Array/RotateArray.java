package Array;

public class RotateArray {

    public static void bruteForce(int[] nums, int d) {
        if(d==0)
            return;

        int n = nums.length;
        d = d%n;
        reverseArray(nums, 0, d-1); //O(N)
        reverseArray(nums, d, n-1); //O(N)
        reverseArray(nums, 0, n-1); //O(N)

        for (int x: nums) {
            System.out.print(x+ " ");
        }
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,7,2,1,9,10,12};
        int d= 9;
        bruteForce(nums, d);
    }
}
