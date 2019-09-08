package 多线程.calc;

/**
 * @author : S K Y
 * @version :0.0.1
 */
/* 设计四个线程对象，其中两个线程执行减操作，另外两个执行加操作.*/
class TestResource{
    private int num = 0;
    private boolean flag = true;
    public synchronized void add() throws Exception {
        if(this.flag == false) {
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("【加法操作 - "+ Thread.currentThread().getName()+"】num="+ num);
        this.flag = false;
        super.notifyAll();
    }
    public synchronized void sub() throws Exception{
        if(this.flag == true) {
            super.wait();
        }
        Thread.sleep(200);
        this.num--;
        System.out.println("【减法操作- " + Thread.currentThread().getName() + "】num=" + num);
        this.flag = true;
        super.notifyAll();
    }
}

class TestAddThread implements Runnable{
    private TestResource resource;
    public TestAddThread(TestResource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for(int x=0;x<50;x++) {
            try {
                this.resource.add();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class TestSubThread implements Runnable{
    private TestResource resource;
    public TestSubThread(TestResource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for(int x=0;x<50;x++) {
            try {
                this.resource.sub();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        TestResource resource = new TestResource();
        TestAddThread st = new TestAddThread(resource);
        TestSubThread at = new TestSubThread(resource);
        new Thread(at, "加法线程-A").start();
        new Thread(at, "加法线程-B").start();
        new Thread(st, "加法线程-C").start();
        new Thread(st, "加法线程-D").start();
    }
}