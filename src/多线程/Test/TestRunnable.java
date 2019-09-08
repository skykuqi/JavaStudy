package 多线程.Test;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class TestRunnable  implements Runnable{
    private String name;

    public TestRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name +  "运行,i = " + i);
        }
    }
}
class TestRun {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            String title = "线程对象:" + (i + 1);
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    System.out.println(title + "运行,j = " + j);
                }
            }).start();
        }
    }
}
