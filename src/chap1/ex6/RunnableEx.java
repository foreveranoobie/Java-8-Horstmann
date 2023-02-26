package chap1.ex6;

public interface RunnableEx {
/*    default void run() {
        try {
            doRun();
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }*/

    void doRun() throws Throwable;
}
