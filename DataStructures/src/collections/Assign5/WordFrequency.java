package collections.assign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner document = new Scanner(new File("src/bookFiles/input/Keywords.txt"));
        HashSet<String> words = new HashSet<String>();

        while(document.hasNext())
            if(words.add(document.next()))
            words.add(document.next());

        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for(String word : words){
            int count = 0;
            while(document.hasNext()){
                if(word.equals(document.next()))
                    count++;
            }
            numOfWords.put(word, count);
        }
        
        for(Map.Entry<String, Integer> keyAndValue : numOfWords.entrySet()){
            System.out.println(keyAndValue.getKey() + "->" + keyAndValue.getValue());
        }
        document.close();
    }
}
