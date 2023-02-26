package chap2.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main1 {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        String words[] = {"Hello,", "world!", "How ", "are ", "you? ", "Nice ", "to ", "meet ", "you ", ", fine!"};
        Long countResult = Arrays.stream(words).parallel().peek(word -> {
            System.out.println(Thread.currentThread().getName());
        }).count();
        System.out.println(countResult);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> callables = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            final int intermI = i;
            callables.add(() -> {
                int count = 0;
                for (int k = (intermI * words.length / 5); k < (intermI + 1) * words.length / 5; k++) {
                    count++;
                }
                return count;
            });
        }
        List<Future<Integer>> resultList = executor.invokeAll(callables);
        executor.shutdown();
        int result = 0;
        for (Future<Integer> future : resultList) {
            result += future.get();
        }
        System.out.println(result);
    }

}