package Backtracking;

public class GenerateParenthesis {


    public static void generateParenthesis(String curr, int diff, int n) {

        if(curr.length()==2*n && diff==0) {
            System.out.println(curr);
            return;
        }

        if(curr.length()==2*n || diff<0) {
            return;
        }

        generateParenthesis(curr+"(", diff+1, n);
        generateParenthesis(curr+")", diff-1, n);
    }

    public static void main(String[] args) {
        int n =3;
        generateParenthesis("", 0, n);
    }
}
