package collections.assign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner doc = new Scanner(new File("src/bookFiles/input/Keywords.txt"));
        String toSplit = "";

        while (doc.hasNext()) {
            toSplit += doc.next().trim().toLowerCase() + " ";
        }

        String[] docWords = toSplit.split(" ");
        int count = 0;
        HashSet<String> word = new HashSet<String>();

        for (String toAdd : docWords)
            if (word.add(toAdd))
                word.add(toAdd);

        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for (String toAdd : word) {
            for (String check : docWords) {
                if (toAdd.equals(check))
                    count++;
            }
            numOfWords.put(toAdd, count);
            count = 0;
        }

        numOfWords = sortMap(numOfWords);
        for (Map.Entry<String, Integer> keyAndValue : numOfWords.entrySet())
            System.out.println(keyAndValue.getKey() + "->" + keyAndValue.getValue());

        doc.close();
    }

    public static LinkedHashMap<String, Integer> sortMap(HashMap<String, Integer> unSortedMap) {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<String, Integer>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;
    }
}