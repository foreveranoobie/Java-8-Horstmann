package chap1.ex6;

import java.util.concurrent.Callable;

public class Main6 {
    public static void main(String[] args) {
/*        new Thread(uncheck(() -> {
            System.out.println("Hello");
            Thread.sleep(1000);
            System.out.println("World!");
        })).start();*/
        uncheckVoid(() -> {
            System.out.println("Hello");
            Thread.sleep(1000);
            System.out.println("World!");
        });
        callableCheck(() -> {
            System.out.println("Hello");
            Thread.sleep(1000);
            System.out.println("World!");
            return null;
        });
    }

    public static void uncheckVoid(RunnableEx runnable) {
        try {
            runnable.doRun();
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void callableCheck(Callable<Void> callable) {
        try {
            callable.call();
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

/*    public static Runnable uncheck(RunnableEx runnable) {
        return runnable;
    }*/
}
