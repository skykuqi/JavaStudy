package 多线程.volatiles;

/**
 * @author : S K Y
 * @version :0.0.1
 * volatile关键字
 */
class MyThread implements Runnable {
    private  volatile int ticket = 5;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 买票处理,ticket =" + ticket--);
        }
    }
}

public class MyVolatile {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "卖票员A").start();
        new Thread(myThread, "卖票员B").start();
        new Thread(myThread, "卖票员C").start();
    }
}
