package 反射.反射应用案例;

import 反射.认识反射机制.entity.Person;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("反射.认识反射机制.entity.Person");
        Object o = aClass.newInstance();    //实例化对象
        System.out.println(o);
    }
}
