package 反射.ClassLoader类加载器;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Message{

}
public class GetClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader loader = Message.class.getClassLoader();        //获取当前类的类加载器
        ClassLoader parent = loader.getParent();    //获取父类加载器
        System.out.println(loader);
        System.out.println(parent);
        System.out.println(parent.getParent());     //获取祖父类加载器
    }
}
