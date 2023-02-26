package chap2.ex9;

import java.util.*;
import java.util.stream.Stream;

public class Main9 {
    public static void main(String... args) {
        Stream<List<Human>> listStream = Stream.empty();
        Random random = new Random();
        List<Human> addList;
        for (int i = 0; i < 3; i++) {
            addList = new ArrayList<>(5);
            for (int n = 0; n < 5; n++) {
                addList.add(new Human(random.nextInt(50)));
            }
            listStream = Stream.concat(listStream, Stream.of(addList)).parallel();
        }
        addList = listStream.parallel().reduce((first, second) -> {
            first.addAll(second);
            return first;
        }).get();
        for (Human hum : addList) {
            System.out.println(hum.getAge());
        }
        int usersAge = addList.stream()
                .reduce(0, (age, human) -> age + human.getAge(), Integer::sum) / 15;
        System.out.println("Average: " + usersAge);
    }
}
