package string.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {


    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        System.out.println(DuplicateWords(st));
    }


    public static String DuplicateWords(String str) {
        String resultHolder = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] arr = str.split (" ");

        for (String a : arr) {
            if (map.get(a) != null) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            resultHolder += entry.getKey() + ": " + entry.getValue() + ", ";
        }
        return resultHolder;
    }
}