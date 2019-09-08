package 多线程.callable;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MySleep {
    public static void main(String[] args) {
        for (int j = 0; j < 5; j++) {
            int index = j;
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + index+ ",i = " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"线程对象").start();
        }
    }
}
