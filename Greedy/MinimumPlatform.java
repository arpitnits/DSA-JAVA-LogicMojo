package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatform {

    static class Event {
        int time;
        int isArrival;

        Event(int t, int a) {
            this.time = t;
            this.isArrival = a;
        }
    }

    static class MinTimeComparator implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2) {
            return Integer.compare(o1.time, o2.time);
        }
    }

    static class ArrivalComparator implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2) {
            return Integer.compare(o2.isArrival, o1.isArrival);
        }
    }

    static int findPlatform(int[] arr, int[] dep, int n) {
        List<Event> events = new ArrayList<>();
        for(int i=0;i<n;i++) {
            events.add(new Event(arr[i], 1)); //arrival
            events.add(new Event(dep[i], 0)); //departure
        }

        events.sort(new MinTimeComparator().thenComparing(new ArrivalComparator()));

        int curr=0, minReq=0;

        for(Event event : events) {
            if(event.isArrival==1)    curr++;
            else curr--;

            minReq = Math.max(minReq, curr);
        }
        return minReq;
    }
}
