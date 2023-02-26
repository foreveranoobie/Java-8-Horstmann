package chap2.ex7;

import java.util.stream.Stream;

public class Main7 {
    public static void main(String... args) {
        System.out.println(Stream.generate(System::currentTimeMillis).limit(10).count());
    }
}
