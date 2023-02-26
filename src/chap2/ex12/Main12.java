package chap2.ex12;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main12 {
    public static void main(String... args) {
        Stream<String> words = Stream.of("Hello", "world", "how are you?", "fine", "nice", "pleased");
        Integer maxLength = words.max(Comparator.comparingInt(String::length)).get().length();
        System.out.println(maxLength + " is max length\n");
        AtomicInteger[] shortWords = new AtomicInteger[maxLength];
        for (int i = 0; i < shortWords.length; i++) {
            shortWords[i] = new AtomicInteger();
        }
        words = Stream.of("Hello", "world", "how are you?", "fine", "nice", "pleased");
        words.parallel().forEach((word) -> shortWords[word.length() - 1].incrementAndGet());
        for (AtomicInteger num : shortWords) {
            System.out.println(num);
        }
    }
}

