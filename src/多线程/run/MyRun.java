package 多线程.run;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyRun {
    public static void main(String[] args) throws InterruptedException {

        Runnable run = ()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行.");
            }
        };
        Thread threadA = new Thread(run,"线程对象A");
        Thread threadB = new Thread(run,"线程对象B");
        Thread threadC = new Thread(run,"线程对象C");
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
