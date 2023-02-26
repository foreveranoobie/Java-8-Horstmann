package chap2.ex13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {
    public static void main(String... args) {
        Stream<String> words = Stream.of("Hello", "world", "how are you?", "fine", "nice", "pleased");
        Map<Integer, List<String>> wordsLength = words.collect(Collectors.groupingBy(String::length));
        for(int num : wordsLength.keySet()){
            System.out.print("Length " + num + " : ");
            for(String word : wordsLength.get(num)){
                System.out.print(word + " ");
            }
            System.out.println();
        }
        words = Stream.of("Hello", "world", "how are you?", "fine", "nice", "pleased");
        Map<Integer, Long> countByLength = words.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        for(int num : countByLength.keySet()){
            System.out.println("Length " + num + " : " + countByLength.get(num) + " word(s)");
        }
    }
}
