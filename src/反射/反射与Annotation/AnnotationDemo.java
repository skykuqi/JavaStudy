package 反射.反射与Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author : S K Y
 * @version :0.0.1
 */
@FunctionalInterface
@Deprecated
interface IMessage {            //存在两个Annotation注解
    public void send();
}

@SuppressWarnings("serial")
class MessageImpl implements IMessage {
    @Override
    public void send() {
        System.out.println("消息发送...");
    }
}

public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取接口上的Annotation信息
        Annotation[] annotations = IMessage.class.getAnnotations();     //获取接口上的所有的Annotation
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("=========================");
        //获取子类上的Annotation
        Annotation[] implAnnotations = MessageImpl.class.getAnnotations();
        for (Annotation implAnnotation : implAnnotations) {
            System.out.println(implAnnotation);
        }
        //尝试获取MessageImpl.toString()方法上的Annotation
        System.out.println("==============================");
        Method send = MessageImpl.class.getDeclaredMethod("send");
        Annotation[] sendAnnotations = send.getAnnotations();
        for (Annotation sendAnnotation : sendAnnotations) {
            System.out.println(sendAnnotation);
        }
    }
}
