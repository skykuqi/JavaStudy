package 多线程.answer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class MyThread implements Callable<String>{
    private boolean flag = false;       //抢答处理
    @Override
    public String call() throws Exception {
        synchronized (this){
            if(this.flag){
                this.flag = false;
                return Thread.currentThread().getName() + "抢答成功!";
            }else {
                this.flag = true;
                return Thread.currentThread().getName() + "抢答失败.";
            }
        }
    }
}
public class MyAnswer{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<String> futureTaskA = new FutureTask<>(myThread);
        FutureTask<String> futureTaskB = new FutureTask<>(myThread);
        FutureTask<String> futureTaskC = new FutureTask<>(myThread);
        new Thread(futureTaskA,"抢答者A").start();
        new Thread(futureTaskB,"抢答者B").start();
        new Thread(futureTaskC,"抢答者C").start();
        try {
            System.out.println(futureTaskA.get());
            System.out.println(futureTaskB.get());
            System.out.println(futureTaskC.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
