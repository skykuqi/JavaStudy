package 反射.Annotation与工厂设计模式整合;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : S K Y
 * @version :0.0.1
 */
interface IMessage {
    public void send(String msg);
}

class MessageImpl implements IMessage {
    @Override
    public void send(String msg) {
        System.out.println("[消息发送]" + msg);
    }
}

class MessageProxy implements InvocationHandler {
    private Object target;


    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public boolean connect() {
        System.out.println("[代理操作]进行消息发送通道的连接");
        return true;
    }

    public void close() {
        System.out.println("[代理操作]关闭连接通道.");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (this.connect()) {
                return method.invoke(this.target, args);
            } else {
                throw new Exception("[error]消息无法进行发送");
            }
        } finally {
            this.close();
        }
    }
}

class Factory {
    private Factory() {
    }
    public static <T> T getInstance(Class<T> tClass) {       //直接返回一个实例化的操作对象
        try {
            return (T) new MessageProxy().bind(tClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> thisClass();
}
@UseMessage(thisClass = MessageImpl.class)
class MessageService{
    private IMessage message;

    public MessageService() {
        UseMessage annotation = MessageService.class.getAnnotation(UseMessage.class);
        this.message = (IMessage) Factory.getInstance(annotation.thisClass());
    }
    public void send(String msg){
        this.message.send(msg);
    }
}
public class AnnotationFactoryDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
       MessageService service = new MessageService();
       service.send("hello");

    }
}
