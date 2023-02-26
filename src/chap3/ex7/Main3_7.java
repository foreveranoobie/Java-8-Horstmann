package chap3.ex7;

import chap3.ex7.comp.ComparatorType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Main3_7 {

    private static Map<ComparatorType, Comparator<String>> suppliers;

    public static void main(String... args) {
        initSuppliers();
        /*String[] words = new String[]{"Hello,", "world", "how", "are", "You?"};
        Arrays.stream(words).sorted(getComparator(ComparatorType.REVERSED_CASE_SENSITIVE)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(words).sorted(getComparator(ComparatorType.REVERSED)).forEach(System.out::println);*/
        String[] words = new String[]{"Hell o,", "wo    rld", "how   ", " are", "Yo  u?"};
        Arrays.stream(words).sorted(getComparator(ComparatorType.SPACE_SENSITIVE)).forEach((str) -> System.out.println(str + "| length " + str.length()));
    }

    public static Comparator<String> getComparator(ComparatorType comparatorType) {
        return suppliers.get(comparatorType);
    }

    private static void initSuppliers() {
        suppliers = new HashMap<>();
        suppliers.put(ComparatorType.NORMAL, String::compareToIgnoreCase);
        suppliers.put(ComparatorType.CASE_SENSITIVE, String::compareTo);
        suppliers.put(ComparatorType.REVERSED, String.CASE_INSENSITIVE_ORDER.reversed());
        suppliers.put(ComparatorType.REVERSED_CASE_SENSITIVE, Comparator.reverseOrder());
        suppliers.put(ComparatorType.SPACE_SENSITIVE, (first, second) -> {
            int f = Arrays.stream(first.split(""))
                    .reduce(0, (id, str) -> str.equals(" ") ? id = id + 1 : id, Integer::sum);
            int s = Arrays.stream(second.split(""))
                    .reduce(0, (id, str) -> str.equals(" ") ? id = id + 1 : id, Integer::sum);
            return Integer.compare(f, s);
        });
    }
}
