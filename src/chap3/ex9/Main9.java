package chap3.ex9;

import chap3.ex9.person.Person;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main9 {

    private static Person person;

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException {
        person = new Person("John", "Doe", "United Kingdom", 28);
        lexicographicComparator("firstname");
    }

    public static int lexicographicComparator(String... fields)
            throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Field firstField = person.getClass().getDeclaredField(fields[0]);
        firstField.setAccessible(true);
        System.out.println(firstField.get(Class.forName(firstField.getGenericType().getTypeName()).getDeclaredConstructor().newInstance()));
        return 0;
    }
}
