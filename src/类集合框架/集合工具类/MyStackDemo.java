package 类集合框架.集合工具类;

import java.util.Stack;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyStackDemo {
    public static void main(String[] args) {
        Stack<String> all = new Stack<>();
        all.push("A");
        all.push("B");
        all.push("C");
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
    }
}
