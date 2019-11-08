package collections.assign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner document = new Scanner(new File("src/bookFiles/input/Keywords.txt"));
        HashSet<String> words = new HashSet<String>();
        int count = 0;

        while (document.hasNext()) {
            if (words.add(document.next()))
                words.add(document.next());
        }
        document.reset();
        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for (String word : words) {
            while (document.hasNext()) {
                if (word.equals(document.next()))
                    count++;
            }
            numOfWords.put(word, count);
            document.reset();
            count = 0;
        }

        numOfWords = sortByValue(numOfWords);
        System.out.println(numOfWords);
        document.close();
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
