package chap2.ex2;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    public static void main(String... args) {
        String words[] = {"Hello,", "world!", "How ", "are ", "you? ", "Nice ", "to ", "meet ", "you ", ", fine!"};
        String[] longestWords = Arrays.stream(words).sorted(Comparator.comparingInt(String::length).reversed()).limit(5).toArray(String[]::new);
        Arrays.stream(words).sorted(Comparator.comparingInt(String::length).reversed()).filter((word) -> {
            System.out.println(word);
            return true;
        }).limit(5).count();
    }
}
