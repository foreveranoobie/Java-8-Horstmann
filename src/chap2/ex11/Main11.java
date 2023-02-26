package chap2.ex11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main11 {
    public static void main(String... args) {
        String word = "appleea";
        word = Stream.of(word.split("")).distinct().reduce(String::concat).get();
        System.out.println(word);

    }
}
