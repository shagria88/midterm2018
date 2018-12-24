package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> map = new HashMap<Integer, String>();
        //implement

        System.out.println(findTheLargestWord(s));

    }

    public static String findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        String[] arr = wordGiven.split(" ");
        for (String str: arr) {

            if (map.get(str) == null){
                map.put(str.length(),str);
            }

        }

        int map1 = 0;
        String word = null;

        for (Map.Entry entry: map.entrySet()) {
            if ((int)entry.getKey() > map1){
                map1 = (int)entry.getKey();
                word = (String) entry.getValue();
            }
        }
        return map +" "+ word;
    }
}
