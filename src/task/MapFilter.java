package task;

import java.util.*;

public class MapFilter {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        List<Person> list1 = Arrays.asList(
                new Person("Вася", "Иванов"),
                new Person("Петр", "Петров"),
                new Person("Виктор", "Сидоров"),
                new Person("Сергей", "Савельев"),
                new Person("Вадим", "Викторов")
        );

        List<Person> list2 = Arrays.asList(
                new Person("Вася", "Иванов"),
                new Person("Петр", "Петров"),
                new Person("Виктор", "Иванов"),
                new Person("Сергей", "Савельев"),
                new Person("Вадим", "Петров")
        );

        list1.forEach(person -> map1.put(person.getName(), person.getLastName()));
        list2.forEach(person -> map2.put(person.getName(), person.getLastName()));

        System.out.println(isUnique(map1));
        System.out.println(isUnique(map2));
    }

    public static boolean isUnique(Map<String, String> map) {
        Iterator<String> itr = map.values().iterator();
        String value;
        int repeat;
        System.out.println(map.values());
        while (itr.hasNext()) {
            value = itr.next();
            repeat = Collections.frequency(map.values(), value);
            if (repeat > 1) {
                System.out.printf("Фамилия %s повторяется %d раз.\n", value, repeat);
                return false;
            }
        }
        return true;
    }
}
