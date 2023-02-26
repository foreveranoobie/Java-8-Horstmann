import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String reduced = Arrays.stream(new String[]{null})
                .reduce("Ha-ha, doesn't work ->", (firstString, secondString) -> firstString + " " + secondString);
        System.out.println(reduced);
        doSomething(Main::printSomething);
        Object[] strings = Stream.concat(Arrays.stream(new String[]{"Something"}), Arrays.stream(new String[]{"different"})).toArray();
        for (Object obj : strings) {
            System.out.println(obj);
        }
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        Stream.generate(() -> rand.nextInt(5))
                .limit(5)
                .filter(val -> val >= 3).findFirst()
                .ifPresent((val) ->
                {
                    numbers.add(val);
                    System.out.println(val);
                });
        System.out.println(numbers.size());
    }

    public static void doSomething(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void printSomething() {
        System.out.println("Hello, world!");
    }
}
