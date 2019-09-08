package 常用类库.定时任务;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyTimer extends TimerTask {        //任务主体
    @Override
    public void run() {     //多线程的处理方法
        System.out.println(Thread.currentThread().getName() + " 定时任务执行,当前时间: " + System.currentTimeMillis());
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        //延迟两秒执行,每次执行间隔为一秒
        timer.schedule(new MyTimer(),2000,1000);
    }
}
