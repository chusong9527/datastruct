import array.Array;

import java.awt.*;
import java.util.*;

/**
 * @author songwb
 * @date 2019/4/10 11:47
 */
public class testTreeMap {

    private static class Student {
        public String name;
        public Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeMap<Student, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(x -> x.age));
        new Array<>();
        new TreeSet<>();

//        ArrayList
       treeMap.put(new Student("詹三", 1), 1);
       treeMap.put(new Student("李四", 9), 2);
       treeMap.put(new Student("王五", 3), 3);
        for(Map.Entry entry:treeMap.entrySet()) {
            System.out.println(entry.getKey() + "=====" + entry.getValue());
        }
    }
}
