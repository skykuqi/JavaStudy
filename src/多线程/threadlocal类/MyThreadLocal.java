package 多线程.threadlocal类;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Channel {      //消息的发送通道
    //私有静态常量
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<>();

    public static void setMessage(Message message) {
        THREAD_LOCAL.set(message);
    }

    public static void send() {      //发送消息
        System.out.println(Thread.currentThread().getName() + " 消息发送: " + THREAD_LOCAL.get().getInfo());
    }
}

class Message {      //要发送的消息体
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

public class MyThreadLocal {
    public static void main(String[] args) {
        new Thread(() -> {
            Message message = new Message();        //实例化消息主体对象
            message.setInfo("第一个线程的消息信息");        //设置要发送的消息内容
            Channel.setMessage(message);
            Channel.send();     //发送消息
        },"消息发送者A").start();
        new Thread(() -> {
            Message message = new Message();        //实例化消息主体对象
            message.setInfo("第二个线程的消息信息");        //设置要发送的消息内容
            Channel.setMessage(message);
            Channel.send();     //发送消息
        },"消息发送者B").start();
        new Thread(() -> {
            Message message = new Message();        //实例化消息主体对象
            message.setInfo("第三个线程的消息信息");        //设置要发送的消息内容
            Channel.setMessage(message);
            Channel.send();     //发送消息
        },"消息发送者C").start();
    }
}
