package main.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepeatedWordInFile {
    public static void repeatedWordInFile(String filePath) throws IOException {
        Map<String,Integer> wordCountMap = new HashMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String currentLine = bufferedReader.readLine();

        while (null != currentLine){
            String[] words = currentLine.split(" ");

            for (String word : words){
                if(wordCountMap.containsKey(word)){
                    wordCountMap.put(word,wordCountMap.get(word)+1);
                }else{
                    wordCountMap.put(word,1);
                }
            }

            currentLine = bufferedReader.readLine();
        }

        int count = 0;

        Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();

        String mostRepeatedWord = null;
        for (Map.Entry<String, Integer> entry : entrySet)
        {
            if(entry.getValue() > count)
            {
                mostRepeatedWord = entry.getKey();

                count = entry.getValue();
            }
        }

        System.out.println("The most repeated word in input file is : "+mostRepeatedWord);

        System.out.println("Number Of Occurrences : "+count);
    }
}
