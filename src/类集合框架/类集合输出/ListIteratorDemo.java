package 类集合框架.类集合输出;

import java.util.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("Hello");
        all.add("World");
        all.add("test");
        ListIterator<String> iterator = all.listIterator();
        System.out.println("由前向后输出:");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("由后向前输出:");
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
