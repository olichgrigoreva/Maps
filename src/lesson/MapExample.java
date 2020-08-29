package lesson;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        //ассоциативный массив
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivanov", 4);
        map.put("Sidorov", 3);
        map.put("Petrov", 5);
        map.put(null, 2); //hash = 0
        map.put(null, 4); //перезапись
        map.put("Petrosyan", null);
        //Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        /*map.compute("Petrosyan", (k, v) -> {
            return (v==null) ? 0 : v;
        }); или */
        map.compute("Petrosyan", (k, v) -> (v==null) ? 0 : v); //если value null, то заменяем его на 0
        printEntrySet(map.entrySet());

        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Ivanov", 4);
        sortedMap.put("Sidorov", 3);
        sortedMap.put("Petrov", 5);
        //sortedMap.put(null, 2); //nullPointerException
        sortedMap.put("Petrosyan", null);
        printEntrySet(sortedMap.entrySet()); //вывод отсортированный: по алфавиту

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Ivanov", 4);
        linkedHashMap.put("Sidorov", 3);
        linkedHashMap.put("Petrov", 5);
        linkedHashMap.put(null, 2);
        linkedHashMap.put(null, 4);
        linkedHashMap.put("Petrosyan", null);
        linkedHashMap.remove("Petrosyan");
        printEntrySet(linkedHashMap.entrySet()); //вывод в порядке добавления
        linkedHashMap.keySet(); //мн-во ключей мапы
        linkedHashMap.values(); //мн-во значений, но хз какие ключи
    }

    //вывод содержимого EntrySet
    public static void printEntrySet(Set<Map.Entry<String, Integer>> entrySet) {
        for (Map.Entry entry : entrySet) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
    }
}
