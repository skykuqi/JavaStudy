package 类集合框架.集合工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyCollectionsDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        //追加元素
        Collections.addAll(all, "python", "c++", "java", "Go", "Ruby","jsp","json","html","css");
        Stream<String> stream = all.stream();       //实例化Stream对象
        //将满足条件的数据收集起来转化为List集合
        List<String> list = stream.filter((ele) -> ele.toLowerCase().contains("j")).skip(1).limit(2).collect(Collectors.toList());//断言型的函数式接口
        System.out.println(list);
    }
}
