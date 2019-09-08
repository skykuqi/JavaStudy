package 常用类库.finalize;

import java.util.Date;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Demo implements Runnable {
    public Demo() {
        System.out.println("[构造方法]在一个雷电交加的夜晚,这个对象诞生了");
    }

    @Override
    public void run() {         //执行清除的时候执行的是此操作
        System.out.println("[回收]最终这个对象还是会消失");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("[回收]最终这个对象还是会消失");
        throw new RuntimeException();
    }
}

class DemoCleaning implements AutoCloseable {     //实现清除的处理
    @Override
    public void close() throws Exception {

    }
}

public class FinalizeDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Demo();
        }
        String str = "";
        for (int i = 0; i < 300000; i++) {
            str += i;
        }
    }
}
