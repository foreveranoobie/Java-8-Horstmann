package chap2.ex10;

import java.util.stream.Stream;

public class Main10 {
    public static void main(String... args) {
        Stream<Double> doubles = Stream.generate(Math::random).limit(15);
        double result = doubles.reduce(0d, (first, second) -> first + (second / 15));
        /*double result = doubles.reduce(Double::sum).get();*//*
        result = result / 15;*/
        System.out.println(result);
    }
}
