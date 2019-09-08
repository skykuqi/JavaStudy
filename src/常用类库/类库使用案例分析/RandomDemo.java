package 常用类库.类库使用案例分析;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class NumberFactory {
    public static Random random = new Random();

    /**
     * 通过随机数来生成一个数组的内容,该内容不包括有0
     *
     * @param length 呀开辟的数组大小
     * @return 包含随机数内容的数组
     */
    public static int[] create(int length) {
        int data[] = new int[length];
        int foot = 0;
        while (foot < length) {
            int num = random.nextInt(30);
            if (num != 0) {
                data[foot] = num;
                foot++;
            }
        }
        return data;
    }
}

public class RandomDemo {
    public static void main(String[] args) {
        /*利用Random类产生五个1-30之间(包括1和30)的随机整数*/
       int result[] = NumberFactory.create(5);
        System.out.println(Arrays.toString(result));
    }
}
