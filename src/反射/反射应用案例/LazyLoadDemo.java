package 反射.反射应用案例;

import java.util.regex.Pattern;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Singleton {
    //在对象实例化的时候,应该立刻与主内存中的实例对象保持同步,而不应该存在副本
    private static volatile Singleton instance = null;

    private Singleton() {
        System.out.println(Thread.currentThread().getName() + " 实例化单例对象");
    }

    public static Singleton getInstance() {
        synchronized (Singleton.class) { //static方法只能使用Singleton.class
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("单例模式加载");
    }

}

public class LazyLoadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            }, "[单例创建者" + (i + 1) + "]").start();
        }
    }
}
