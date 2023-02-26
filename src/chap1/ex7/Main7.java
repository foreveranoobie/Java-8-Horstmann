package chap1.ex7;

public class Main7 {
    public static void main(String[] args) {
        new Thread(andThen(() -> System.out.println("Hello"), () -> System.out.println("World!"))).start();
    }

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
