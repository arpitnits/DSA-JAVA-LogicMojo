package Stack;

import java.util.Stack;

public class CelebrityProblem {

    public int celebrity(int[][] M, int n) {

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++) s.push(i);

        while(s.size()>1) {
            int a = s.pop();
            int b = s.pop();

            //if A know B and B doesn't know A
            if(M[a][b]==1 && M[b][a]==0) {
                s.push(b);
            }

            //if B know A and A doesn't know B
            else if(M[a][b]==0 && M[b][a]==1) {
                s.push(a);
            }
        }

        if(s.size()==0) return -1;

        int celeb = s.pop();

        for(int i=0;i<n;i++) {
            if(i!=celeb && M[celeb][i]==1)
                return -1;
        }

        for(int i=0;i<n;i++) {
            if(i!=celeb && M[i][celeb]==0)
                return -1;
        }

        return celeb;
    }
}
