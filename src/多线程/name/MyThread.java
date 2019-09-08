package 多线程.name;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class TestRun {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "线程对象").start();
        myThread.run();     //对象直接调用run()方法

    }
}
