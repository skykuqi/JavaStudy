package 类集合框架.类集合输出;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyEnumerationDemo {
    public static void main(String[] args) {
        Vector<String> all = new Vector<>();
        all.add("Hello");
        all.add("World");
        all.add("test");
        for (String s : all) {
            System.out.println(s);
        }
    }
}
