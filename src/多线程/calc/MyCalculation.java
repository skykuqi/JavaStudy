package 多线程.calc;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Resource {        //定义一个操作的资源
    private volatile int num = 0;        //定义要进行加减操作的数据
    /*flag = true 表示可以进行加法操作,无法进行减法操作
     * flag = false 表示可以进行减法操作,无法进行加法操作*/
    private volatile boolean flag = true;

    public synchronized void add() throws InterruptedException {
        if (!this.flag) {                 //现在需要执行的是减法操作,加法操作需要等待
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("[加法操作-" + Thread.currentThread().getName() + "]num = " + this.num+ " " + this.flag);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void sub() throws InterruptedException {
        if (this.flag) {            //现在进行的是减法操作,加法操作需要等待
            super.wait();
        }
        Thread.sleep(200);
        this.num--;
        System.out.println("[减法操作-" + Thread.currentThread().getName() + "]num = " + this.num + " " + this.flag);
        this.flag = true;
        super.notifyAll();
    }
}

class AddThread implements Runnable {
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable {
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyCalculation {
    public static void main(String[] args) {
        Resource resource = new Resource();
        AddThread addThread = new AddThread(resource);
        SubThread subThread = new SubThread(resource);
        new Thread(addThread, "加法线程A").start();
        new Thread(addThread, "加法线程B").start();
        new Thread(subThread, "减法线程A").start();
        new Thread(subThread, "减法线程B").start();
    }
}
