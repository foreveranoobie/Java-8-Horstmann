package chap2.ex5;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Main5 {
    public static void main(String... args) {
        long m = 2;
        int c = 11;
        long a = 25_214_903_917L;
        for (int i = 0; i < 48; i++) {
            m *= 2;
        }
        final long finM = m;
        Stream<Long> res = Stream.iterate(1L, (num) -> num = ((a * num) + c) % finM).limit(10);
        res.forEach(System.out::println);
    }
}
