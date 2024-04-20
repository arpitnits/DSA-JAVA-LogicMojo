package Backtracking;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n , char src, char dest, char aux) {

        if(n==1) {
            System.out.println("move disk 1 from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, src, aux, dest);
        System.out.println("Move disk "+ n + " from"  + src + "to" + dest);
        towerOfHanoi(n-1, aux, dest, src);
    }

    public static void main(String[] args) {
        int disc=3;
        char srcPeg = 'A';
        char auxPeg = 'B';
        char destPeg = 'C';

        towerOfHanoi(disc, srcPeg, destPeg, auxPeg);
    }
}
