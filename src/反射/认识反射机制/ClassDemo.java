package 反射.认识反射机制;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Person {   //采用自定义的程序类

}

public class ClassDemo {
    public static void main(String[] args) {
        Class<? extends Person> cls = Person.class;
        System.out.println(cls);
        System.out.println(cls.getName());  //获取类的完成名称
    }
}
