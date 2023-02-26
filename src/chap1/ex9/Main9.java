package chap1.ex9;

import java.util.Random;

public class Main9 {
    public static void main(String[] args) {
        Collection2<Integer> collection2 = new Collection2<>();
        Random rand = new Random();
        int counter = 0;
        int num;
        for (int i = 0; i < 20; i++) {
            num = rand.nextInt(20);
            if (num > 6) {
                counter++;
            }
            collection2.add(num);
        }
        collection2.forEachIf((number) -> System.out.println(number + " is bigger than 6"), (number) -> number > 6);
        System.out.println("Counter is " + counter);
    }
}
