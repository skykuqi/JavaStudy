package 常用类库.RunTime类;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyRunTime {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); //获取实例化对象
        System.out.println(runtime.availableProcessors());  //返回可用于Java虚拟机的处理器数量。
        System.out.println("获取最大可用内存空间: " + runtime.maxMemory());
        System.out.println("获取可用内存空间: " + runtime.totalMemory());
        System.out.println("获取空闲内存空间: " + runtime.freeMemory());
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += i;
        }
        System.out.println("获取最大可用内存空间: " + runtime.maxMemory());
        System.out.println("获取可用内存空间: " + runtime.totalMemory());
        System.out.println("获取空闲内存空间: " + runtime.freeMemory());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runtime.gc(); //手工进行GC处理
        System.out.println("获取最大可用内存空间: " + runtime.maxMemory());
        System.out.println("获取可用内存空间: " + runtime.totalMemory());
        System.out.println("获取空闲内存空间: " + runtime.freeMemory());
    }
}
