package lesson;

import java.util.HashMap;
import java.util.Map;

public class BlackBoxExample {
    public static void main(String[] args) {
        BlackBox object1 = new BlackBox(1,3);
        BlackBox object2 = new BlackBox(1,3);
        BlackBox object3 = new BlackBox(2,3);
        HashMap<BlackBox, Integer> map = new HashMap<>();
        map.put(object1,10);
        map.put(object2,15);
        map.put(object3,20);

        System.out.println(map.size()); //2 объекта, т.к. КЛЮЧИ разные (можно раскомментить equals и hashCode)

        for (Map.Entry e : map.entrySet()){
            System.out.println(e.toString());
        }
        object3.a = 1; //почему 15???

        System.out.println(map.get(object3));

        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
    }
}
