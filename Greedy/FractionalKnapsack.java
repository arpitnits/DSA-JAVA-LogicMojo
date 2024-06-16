package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {


    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class Pair {
        double ratio;
        int index;

        Pair(double r,int i) {
            this.ratio =r;
            this.index =i;
        }
    }

    static class MaxValueRatioComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return Double.compare(o2.ratio, o1.ratio);
        }
    }

    double fractionalKnapsack(int W, Item[] arr, int n) {

        List<Pair> valueRatioList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            Item item = arr[i];
            valueRatioList.add(new Pair(item.value*1.0/item.weight, i));
        }
        valueRatioList.sort(new MaxValueRatioComparator());
        int i =0, totalVal=0;
        while(W>0 && i<n) {

            double ratio = valueRatioList.get(i).ratio;
            Item item = arr[valueRatioList.get(i).index];

            if(item.weight<=W) {
                totalVal+= item.value;
            } else {
                totalVal+= W*ratio;
            }
            W = W - item.weight;
            i++;
        }
        return totalVal;
    }
}
