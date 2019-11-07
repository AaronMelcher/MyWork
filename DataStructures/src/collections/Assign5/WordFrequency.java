package collections.assign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner document = new Scanner(new File("src/bookFiles/input/Keywords.txt"));
        HashSet<String> words = new HashSet<String>();
        ArrayList<String> allWords = new ArrayList<String>();
        int count = 0;
        String temp = "";

        while (document.hasNext()){
            temp = document.next();
            if(words.add(temp.trim()))
                words.add(temp.trim());
            allWords.add(temp);
        }

        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for(String word : words){
            for(String check : allWords){
                if(word.equals(check))
                    count++;
            }
            numOfWords.put(word, count);
            count = 0;
        }

        for (Map.Entry<String, Integer> keyAndValue : numOfWords.entrySet()) {
            System.out.println(keyAndValue.getKey() + "->" + keyAndValue.getValue());
        }
        document.close();
    }
}
