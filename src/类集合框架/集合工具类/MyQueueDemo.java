package 类集合框架.集合工具类;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyQueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("X");   //追加数据,通过队尾增加
        queue.offer("A");  //追加数据,通过队尾增加
        queue.offer("Z");  //追加数据,通过队尾增加
        System.out.println(queue.poll());       //弹出数据X
        System.out.println(queue.poll());       //弹出数据A
        System.out.println(queue.poll());       //弹出数据Z
    }
}
