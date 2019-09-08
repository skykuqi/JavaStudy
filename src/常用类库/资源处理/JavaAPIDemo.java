package 常用类库.资源处理;

/**
 * @author : S K Y
 * @version :0.0.1
 */
interface IMessage extends AutoCloseable {
    public void send();     //消息发送
}

class NetMessage implements IMessage {
    private String msg;

    public NetMessage(String msg) {
        this.msg = msg;
    }

    public boolean open() {
        System.out.println("[OPEN]获取消息发送链接资源");
        return true;
    }

    @Override
    public void send() {
        if (open()) {
            System.out.println("[***发送消息***] " + this.msg);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("[CLOSE]关闭消息发送通道");
    }
}

public class JavaAPIDemo {
    public static void main(String[] args) {
        try (IMessage message = new NetMessage("你好")) {
                message.send();     //发送消息
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
