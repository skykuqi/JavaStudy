package 多线程.Test;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class MyThread extends Thread {        //线程的主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    //线程的主体方法
    /*多线程要执行的功能都应该在run()方法中进行定义,需要说明的是,在正常情况下要产生实例化对象,然后再去调用类中
     * 提供的方法,但是run()方法是不能够被直接调用的,牵扯到操作系统的资源调度问题,所以要想启动多线程,需要调用
     * start()方法*/
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "运行,i = " + i);
        }
    }
}

class ThreeThread {
    public static void main(String[] args) {
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}

