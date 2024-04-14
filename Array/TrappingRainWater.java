package Array;

public class TrappingRainWater {

    public static void trapOptimised(int[] height) {
        int n = height.length;
        int l=1, r= n-2;
        int lMax = height[0];
        int rMax = height[n-1];

        int saved =0;

        while(l<=r) {
            if(lMax<=rMax) {
                if(height[l] <= lMax) {
                    saved+= lMax-height[l];
                } else {
                    lMax = height[l];
                }
                l++;
            } else {
                if(height[r] <= rMax) {
                    saved+= rMax-height[r];
                } else {
                    rMax = height[r];
                }
                r--;
            }
        }
        System.out.println("Total saved: "+ saved);
    }
    public static void trapWithExtraSpace(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = 0;
        for(int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        rightMax[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        int saved = 0;
        for(int i=1;i<n-1;i++) {
            saved+= Math.max(0, Math.min(leftMax[i], rightMax[i])-height[i]);
        }
        System.out.println("Total saved: "+ saved);
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trapWithExtraSpace(height);
        trapOptimised(height);
    }
}
