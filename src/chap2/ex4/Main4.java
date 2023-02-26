package chap2.ex4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main4 {
    public static void main(String... args) {
        int[] values = {1, 4, 9, 16};
        Stream<Integer> stream = Stream.of(values).flatMapToInt(Arrays::stream).boxed().peek(System.out::println);
        System.out.println(stream.count());
    }
}
