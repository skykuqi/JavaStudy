package 多线程.interrupt;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(()->
        {
            System.out.println("***我需要睡觉补充精力***");
            try {
                Thread.sleep(10000);        //预计准备休眠10秒
                System.out.println("***我睡够了,可以继续写代码了***");
            } catch (InterruptedException e) {
                System.out.println("===打扰我睡觉,我还怎么写代码===");
            }
        });
        thread.start();     //线程开始睡觉
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        //查看线程中断了吗
        boolean interrupted = thread.isInterrupted();
        if(!interrupted){
            System.out.println("打扰你睡觉");
            thread.interrupt();             //中断执行
        }
    }
}
