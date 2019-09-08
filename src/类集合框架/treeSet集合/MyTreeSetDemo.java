package 类集合框架.treeSet集合;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age < o.age){
            return -1;
        }else if(this.age > o.age){
            return 1;
        }else {
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class MyTreeSetDemo {
    public static void main(String[] args) {
        Set<Person> all = new TreeSet<>();
        all.add(new Person("张三", 19));
        all.add(new Person("李四", 19));      //年龄相同,但是姓名不同
        all.add(new Person("王五", 20));      //数据重复
        all.add(new Person("王五", 20));      //数据重复
        all.add(new Person("小强", 78));
        all.forEach(System.out::println);

    }
}
