package 多线程.procedure;

/**
 * @author : S K Y
 * @version :0.0.1
 * 线程的生产者与消费者模型
 */
class Message {          //消息处理类
    private String title;
    private String content;
    /*flag = true 允许生产,但是不允许消费
     * flag = false 允许消费,但是不允许生产*/
    private boolean flag = true;

    public Message() {
    }

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();                   //当前存在获取,需等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;      //已经生产完成
        super.notify();         //唤醒等待的线程
    }

    public synchronized String get() {
        if (this.flag) {      //还未生产,需要等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            flag = true;
            return this.title + " " + this.content;
        } finally {     //不管如何都要执行
            super.notify();     //唤醒等待线程
        }
    }

}

class Procedure implements Runnable {        //生产者
    private Message message;

    public Procedure(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                message.set("张三", "宇宙大帅哥");
            } else {
                message.set("李四", "猥琐第一人");
            }
        }
    }
}

class Consuemer implements Runnable {        //消费者
    private Message message;

    public Consuemer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " + message.get());
        }
    }
}

class MyProcedure {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Procedure(message)).start();     //启动生产者
        new Thread(new Consuemer(message)).start();     //启动消费者
    }
}
