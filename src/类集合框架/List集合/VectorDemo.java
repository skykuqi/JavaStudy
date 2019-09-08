package 类集合框架.List集合;

import java.util.List;
import java.util.Vector;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class VectorDemo {
    public static void main(String[] args) {
        List<String> all = new Vector<>();
        all.add("hello");
        all.add("hello");
        all.add("world");
        all.add("test");
        all.forEach(System.out::println);
    }
}
