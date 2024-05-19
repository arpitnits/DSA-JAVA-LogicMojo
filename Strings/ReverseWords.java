package Strings;

public class ReverseWords {

    public String reverseWords(String s) {

        //s = "the  sky is blue"
        int n = s.length();
        String ans = "";
        String temp = "";
        for(char ch : s.toCharArray()) {
            if(ch!=' ') {
                temp+= ch;
            } else if(temp!=""){
                if(ans.equals("")) {
                    ans = temp;
                } else {
                    ans = temp + ' ' + ans;
                }
                temp="";
            }
        }

        if(temp!=""){
            if(ans.equals("")) {
                ans = temp;
            } else {
                ans = temp + ' ' + ans;
            }
        }
        return ans;
    }
}
