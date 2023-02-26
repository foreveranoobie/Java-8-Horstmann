package chap2.ex8;

import java.util.Iterator;
import java.util.stream.Stream;

public class Main8 {
    public static void main(String... args) {
        Stream<Integer> stream = zip(Stream.of(1, 2, 3, 4, 5), Stream.of(5, 6, 7));
        stream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Stream<T> resultStream = Stream.empty();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            resultStream = Stream.concat(resultStream, Stream.of(firstIterator.next(), secondIterator.next()));
        }
        return resultStream;
    }
}
