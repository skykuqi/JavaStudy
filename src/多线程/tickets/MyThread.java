package 多线程.tickets;

/**
 * @author : S K Y
 * @version :0.0.1
 * 利用买票程序来实现多个线程的资源并发访问
 */
public class MyThread implements Runnable {
    private int tickt = 5;
    private String title;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.tickt > 0) {
                System.out.println(this.title + "卖票 ,ticket = " + this.tickt--);
            }
        }
    }
}

class TestRun {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        new Thread(mythread).start();   //第一个线程启动
        new Thread(mythread).start();   //第二个线程启动
        new Thread(mythread).start();   //第三个线程启动
    }
}
