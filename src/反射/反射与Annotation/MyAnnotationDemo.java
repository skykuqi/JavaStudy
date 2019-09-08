package 反射.反射与Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : S K Y
 * @version :0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
        //定义Annotation运行时的策略
@interface DefaultAnnotation {       //自定义的Annotation,
    public String title();      //获取数据

    public String url() default "获取数据的默认值";     //获取数据,默认值
}

class Message {
    @DefaultAnnotation(title = "sendMessage")   //title不具备默认值,因此必须去显示的定义
    public void send(String msg) {
        System.out.println("[消息发送]" + msg);
    }
}

public class MyAnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method method = Message.class.getDeclaredMethod("send", String.class);  //获取指定的方法
        DefaultAnnotation annotation = method.getAnnotation(DefaultAnnotation.class);//获取指定的Annotation1
        String title = annotation.title();      //直接调用Annotation中的方法
        String url = annotation.url();
        System.out.println(title + " " + url);
        String msg = annotation.title() + " " + url;
        method.invoke(Message.class.getDeclaredConstructor().newInstance(),msg);        //利用反射实现消息的发送
    }
}
