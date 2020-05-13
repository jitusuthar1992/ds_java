package main.java1.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFileProcessing {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test2.txt");

        Map<Object, Integer> wordCountMap =  Files.readAllLines(path).stream().map(line->line.split("|"))
                .flatMap(Arrays::stream).collect(Collectors.toMap(
                        k->k,
                        v->1,
                        Integer::sum
                ));

        for (Map.Entry<Object,Integer> entry : wordCountMap.entrySet()){
            System.out.println(entry.getKey()+ " count :"+entry.getValue());
        }
    }
}
