package collections.assign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner doc = new Scanner(new File("src/bookFiles/input/Keywords.txt"));
        String toSplit = "";

        while(doc.hasNext()){
            toSplit += doc.next() + " ";
        }

        String[] docWords = toSplit.split(" ");
        int count = 0;
        HashSet<String> word =  new HashSet<String>();

        for(String toAdd : docWords)
            if(word.add(toAdd))
                word.add(toAdd);

        HashMap<String, Integer> numOfWords = new HashMap<String, Integer>();

        for(String toAdd : word){
            for(String check : docWords){
                if(toAdd.equals(check))
                    count++;
            }
            numOfWords.put(toAdd, count);
            count = 0;
        }
        for(Map.Entry<String, Integer> keyAndValue : numOfWords.entrySet())
            System.out.println(keyAndValue.getKey() + "->" + keyAndValue.getValue());

        doc.close();
    }
}