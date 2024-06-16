package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobScheduling {

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    class MaxProfitComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o2.profit-o1.profit;
        }
    }

    public int[] jobScheduling(Job[] arr, int n) {

        List<Job> jobs = new ArrayList<>(Arrays.asList(arr));

        jobs.sort(new MaxProfitComparator()); //O(NLogN)
        int totalProfit=0;
        int slotsUsed=0;

        boolean[] slotOccupied = new boolean[n+1];

        //O(N^2)
        for(Job job : jobs) {
            int deadline = job.deadline;
            while(deadline>0 && slotOccupied[deadline]) {
                deadline--;
            }
            if(deadline>0) {
                slotOccupied[deadline] = true;
                totalProfit+= job.profit;
                slotsUsed++;
            }
        }

        return new int[]{slotsUsed, totalProfit};
    }
}
