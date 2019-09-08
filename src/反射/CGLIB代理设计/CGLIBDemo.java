package 反射.CGLIB代理设计;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Message {
    public void send() {
        System.out.println("发送消息....");
    }
}

class CGLIBProxy implements MethodInterceptor {  //拦截器
    private Object target;      //保存真实代理对象

    public CGLIBProxy(Object target) {
        this.target = target;
    }

    public boolean connect() {
        System.out.println("[消息代理]进行消息发送通道的连接");
        return true;
    }

    public void close() {
        System.out.println("[消息代理]关闭消息通道");
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object returnData = null;
        if (this.connect()) {
            method.invoke(this.target, objects);
            this.close();
        }
        return returnData;
    }
}

public class CGLIBDemo {
    public static void main(String[] args) {
        Message realObject = new Message();     //真实主题对象
        Enhancer enhancer = new Enhancer();     //负责代理操作的程序类
        enhancer.setSuperclass(realObject.getClass());      //假定一个父类
        enhancer.setCallback(new CGLIBProxy(realObject));       //设置代理类
        Message proxyObject = (Message) enhancer.create();//常见代理对象
        proxyObject.send();
    }
}
