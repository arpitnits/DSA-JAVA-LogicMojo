package Queue;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startIndex = 0;
        int currGain=0;
        int totalGain=0;

        for(int i=0;i<n;i++) {
            totalGain+= (gas[i]-cost[i]);
            currGain+= (gas[i]-cost[i]);


            if(currGain<0) {
                startIndex = i+1;
                currGain=0;
            }
        }

        if(totalGain>=0) {
            return startIndex;
        }
        return -1;
    }
}
