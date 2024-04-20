package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {


    public static void generate(int n, String curr, List<String> res) {
        if(curr.length()==n) {
            res.add(curr);
            return;
        }

        generate(n, curr+"0", res);
        generate(n, curr+"1", res);
    }


    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        int n =6;

        generate(n, "", result);
        System.out.println(result);
    }
}
