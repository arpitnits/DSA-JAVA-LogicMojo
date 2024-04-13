package Array;

public class TwoRepeatedNumbers {

    public static void arrayEleAsIndex(int [] nums, int N) {
        for(int i=0;i<nums.length;i++) {

            int absVal = Math.abs(nums[i]);

            if(nums[absVal] < 0 )
                System.out.println("Repeated Number: " + absVal);
            else
                nums[absVal] = -nums[absVal];
        }
    }



    public static void XOR(int[] nums, int N) {
        int res = 0;

        for(int x : nums)   res = res^x; //O(N)
        for(int i=1;i<=N;i++)   res = res^i; //(N)

        int rightMostSetBit = (res & ~(res-1)); //O(1)

        int set1XOR = 0, set2XOR =0;

        for(int x : nums){
            if((rightMostSetBit & x) == 0) {
                set1XOR = set1XOR^x;
            } else {
                set2XOR = set2XOR^x;
            }
        }

        for(int i=1;i<=N;i++) {
            if((rightMostSetBit & i) == 0) {
                set1XOR = set1XOR^i;
            } else {
                set2XOR = set2XOR^i;
            }
        }

        System.out.println("FirstNumber: " + set1XOR + " Second Number: "+ set2XOR);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] nums = {4,2,2,4,5,1,3};

        XOR(nums, N);
    }
}
