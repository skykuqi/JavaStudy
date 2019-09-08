package 反射.认识反射机制;

import java.util.Date;      //1.当如程序所在的包,知道对象的出处

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class Demo {
    public static void main(String[] args) {
        Date date = new Date();     //2.通过类产生实例化对象
        System.out.println(date.getTime());     //3.根据对象调用类中的方法
    }
}
