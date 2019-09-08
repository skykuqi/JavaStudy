package 常用类库.Random随机数类;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyRandom {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}

class RandomDemo {
    public static void main(String[] args) {
        int data[] = new int[7];            //开辟七个大小的空间
        int foot = 0;       //用于操作data脚标
        Random random = new Random();
        while (foot < 7) {
            int i = random.nextInt(37);
            if (isUse(i, data)) {
                data[foot++] = i;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 判断传入的数字是否为0,以及是否在数组之中
     *
     * @param num  要判断的数字
     * @param temp 已经存在的数据
     * @return 如果数字不是0并且可以使用则返回true, 否则返回false
     */
    public static boolean isUse(int num, int temp[]) {
        if (num == 0) return false;
        for (int i = 0; i < temp.length; i++) {
            if (num == temp[i]) return false;
        }
        return true;
    }
}
