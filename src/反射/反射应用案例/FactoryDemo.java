package 反射.反射应用案例;


/**
 * @author : S K Y
 * @version :0.0.1
 */
interface Service {
    public void service();
}

class HouseService implements Service {
    @Override
    public void service() {
        System.out.println("为您的住房提供服务.");
    }
}

interface Message {
    public void send();     //消息发送
}

class NetMessage implements Message {        //网络消息实现类
    @Override
    public void send() {
        System.out.println("发送网络消息");
    }
}

class Factory {
    private Factory() {
    }     //没有产生实例化对象的意义

    /**
     * 获取接口实例化对象
     *
     * @param className 接口的子类
     * @param tClass    描述的是一个接口的类型
     * @return 如果子类存在则返回指定接口
     * @throws Exception
     */
    public static <T> T getInstance(String className, Class<T> tClass) throws Exception {
        return tClass.cast(Class.forName(className).newInstance());
    }
}

public class FactoryDemo {
    public static void main(String[] args) throws Exception {
        Message message = Factory.getInstance("反射.反射应用案例.NetMessage",Message.class);
        message.send();
        Service instance = Factory.getInstance("反射.反射应用案例.HouseService", Service.class);
        instance.service();
    }
}
