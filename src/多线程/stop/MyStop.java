package 多线程.stop;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class ThreadDemo{
    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 正在运行" + " " + i);
            }
        },"用户线程");          //完成核心代码业务
        Thread daemonThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 正在运行" + " " + i);
            }
        },"守护线程");          //完成核心代码业务
        /*设置为守护线程,则整个程序其他线程运行结束,守护线程也会结束运行*/
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}

public class MyStop {
}
