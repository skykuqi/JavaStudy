package 反射.认识反射机制;



/**
 * @author : S K Y
 * @version :0.0.1
 */
public class GetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //此时Person类位于 entity包中
        Class<?> aClass = Class.forName("反射.认识反射机制.entity.A");
        System.out.println(aClass);
    }
}
