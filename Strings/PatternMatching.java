package Strings;

public class PatternMatching {


    public static void slidingWindow(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        for(int i=0;i<=n-m;i++) {

            int j=0;
            for(;j<m;j++) {
                if(str.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if(j==m) {
                System.out.println("Pattern Matched at index: " + i);
            }
        }
    }

    public static void rabinKarp(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        int p = 3;

        int hp=0, hs=0;

        for(int i=0;i<m;i++) {
            hp = hp + pattern.charAt(i) * (int)Math.pow(p,i);
            hs = hs + str.charAt(i) * (int)Math.pow(p,i);
        }

        for(int i=0;i<=n-m;i++) {
            if(hs==hp) {
                int j=0;
                for(;j<m;j++) {
                    if(str.charAt(i+j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if(j==m) {
                    System.out.println("Pattern Matched at index: " + i);
                }
            }
            if(i+m<n) hs = (hs-str.charAt(i))/p + str.charAt(i+m)*(int)Math.pow(p,m-1);
        }

    }


    public static int[] findLPS(String pattern, int m) {
        int[] lps = new int[m];
        lps[0] = 0;
        int j=0, i=1;

        while (i<m) {
            if(pattern.charAt(j) == pattern.charAt(i)) {
                lps[i] = j+1;
                i++;    j++;
            } else {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int kmpAlgo(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        int[] lps = findLPS(pattern, m);
        int i=0,j=0;
        while((i-j) <= (n-m)) {
            if(pattern.charAt(j) == str.charAt(i)) {
                i++; j++;
            }
            if(j==m) {
                return i-j;
            }

            if(i<n && pattern.charAt(j) != str.charAt(i)) {
                if(j!=0)
                    j=lps[j-1];
                else
                    i++;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
