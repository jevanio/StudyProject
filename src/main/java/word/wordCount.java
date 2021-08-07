package word;

import java.util.HashMap;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) {
        String word = "";
        System.out.println("First version: letters to delete for even word: " + countNonEvenLetters(word));
        //System.out.println("Map version: letters to delete for even word: " + countNonEvenLettersMapVersion(word));
    }

    /*private static int countNonEvenLettersMapVersion(String word) {
        Map<String, Integer> map = Arrays.stream(word.split("")).collect(s -> Collectors.toMap(s,Collectors.counting())));
        return 0;
    }*/

    private static int countNonEvenLetters(String word) {
        Map<String,Integer> mappedWord = new HashMap<>();
        char[] chars = word.toCharArray();
        for(int i=0;i< chars.length; i++) {
            String key = String.valueOf(chars[i]);
            Integer integer = mappedWord.get(key);
            if(integer != null) {
                mappedWord.put(key, ++integer);
            } else {
                mappedWord.put(key,1);
            }
        }
        int result = 0;
        for (Map.Entry<String, Integer> map : mappedWord.entrySet()) {
            if (map.getValue()%2 != 0) {
                result++;
            }
        }

        return result;
    }
}
