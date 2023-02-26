package chap2.ex6;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main6 {
    public static void main(String... args) {
        characterStream("Hello, world!").forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String s) {
        return Stream.iterate(0, (num) -> num = num + 1).limit(s.length()).map(s::charAt);
    }
}
