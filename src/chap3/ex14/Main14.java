package chap3.ex14;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main14 {
    public static void main(String... args) {
        List<Human> humans = new ArrayList<>();
        List<? super Human> students = humans;
        students.add(new Student());
        students.add(new Human());
        students.add(new Doctor());
        System.out.println(students.size());
        addHuman(humans);
        getHuman(new ArrayList<Student>());
    }

    public static void addHuman(List<? super Human> list) {
        list.add(new Student());
        list.add(new Doctor());
        list.add(new Human());
    }

    public static void addStudent(List<? super Student> list) {
        list.add(new Student());
    }

    public static void getHuman(List<? extends Human> list) {
        Human human = list.get(0);
    }

    public static void getStudent(List<? extends Student> list) {
        Student student = list.get(0);
        Human human = list.get(0);
    }

    public static void getDoctor(List<? extends Doctor> list) {
        Doctor doctor = list.get(0);
        Human human = list.get(0);
    }
}
