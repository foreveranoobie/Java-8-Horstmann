package chap1.ex9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Collection2<T> extends ArrayList<T> {
    public void forEachIf(Consumer<T> action, Predicate<T> filter) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (filter.test(val)) {
                action.accept(val);
            }
        }
    }
}
