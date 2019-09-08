package 常用类库.比较器;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Person {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class MyComparator {
    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("小强", 80), new Person("老王", 50), new Person("老李", 60)
                , new Person("小刚", 30)
        };
        Arrays.sort(people,new PersonComparator());
        System.out.println(Arrays.toString(people));
    }
}
