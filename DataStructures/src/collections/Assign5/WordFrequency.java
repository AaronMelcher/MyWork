package collections.assign5;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner document = new Scanner("src/bookFiles/input/historical/constitution.txt");
        HashSet<String> words = new HashSet<String>();

        while(document.hasNext())
            words.add(document.next());

        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for(String word : words){
            Integer count = 0;
            while(document.hasNext()){
                if(word.equals(document.next()))
                    count++;
            }
            numOfWords.put(word, count);
        }
        
    }
}
