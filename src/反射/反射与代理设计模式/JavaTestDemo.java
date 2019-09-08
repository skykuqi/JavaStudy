package 反射.反射与代理设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : S K Y
 * @version :0.0.1
 */
interface IMessage { //传统代理设计必须有接口
    public void send();     //业务方法

}

class MessageReal implements IMessage {
    @Override
    public void send() {
        System.out.println("发送消息.....");
    }
}

class DynamicProxy implements InvocationHandler {
    private Object target;      //保存真实业务对象

    /**
     * 进行真实业务对象与代理代理业务对象之间的绑定处理
     *
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public boolean connect() {
        System.out.println("[消息代理]进行消息发送通道的连接");
        return true;
    }

    public void close() {
        System.out.println("[消息代理]关闭消息通道");
    }

    /**
     * 代理方法调用,代理主题里面执行的方法最终都是此方法
     *
     * @param proxy  要代理的对象
     * @param method 要执行的接口方法名称
     * @param args   传递的参数
     * @return 某一个方法的返回值
     * @throws Throwable 方法调用时产生的错误,继续向上抛出
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[执行方法] " + method);
        Object returnData = null;
        if (this.connect()) {
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
    }

}

public class JavaTestDemo {
    public static void main(String[] args) {
        IMessage message = (IMessage) new DynamicProxy().bind(new MessageReal());
        message.send();
    }
}
