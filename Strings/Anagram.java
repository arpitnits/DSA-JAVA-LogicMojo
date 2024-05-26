package Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        if(s.length()!=t.length())
            return false;

        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) -1);
        }

        for(Map.Entry<Character, Integer> charMap : map.entrySet()) {
            if(charMap.getValue()!=0)
                return false;
        }
        return true;
    }
}
