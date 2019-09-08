package 常用类库.System类;

import sun.misc.Cleaner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MySystem {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时长: " + (endTime-startTime));
    }
}
