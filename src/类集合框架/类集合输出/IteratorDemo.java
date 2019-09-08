package 类集合框架.类集合输出;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Set<String> all = new HashSet<>();
        all.add("Hello");
        all.add("World");
        all.add("test");
        Iterator<String> iterator = all.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if("World".equals(str)){
                iterator.remove();      //删除当前的数据
            }else {
                System.out.println(str);
            }
        }
    }
}
