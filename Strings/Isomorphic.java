package Strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> firstMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        int n = s.length();

        for(int i=0;i<n;i++) {
            if( (firstMap.containsKey(s.charAt(i))  && !firstMap.get(s.charAt(i)).equals(t.charAt(i))) ||
                    (reverseMap.containsKey(t.charAt(i))  && !reverseMap.get(t.charAt(i)).equals(s.charAt(i)))) {
                return false;
            } else {
                firstMap.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
