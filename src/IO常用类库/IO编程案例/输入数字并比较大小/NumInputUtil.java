package IO常用类库.IO编程案例.输入数字并比较大小;

import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class NumInputUtil {
    private NumInputUtil() {
    }

    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * 实现键盘接收数字的操作
     *
     * @param tootTip 提示信息
     * @return 一个正确的输入数字
     */
    public static int getInt(String tootTip) {
        boolean flag = true;
        int num = 0;
        String next = "";
        while (flag) {
            System.out.println(tootTip);        //打印提示信息
            next = INPUT.next();
            if (next.matches("\\d+")) {
                num = Integer.parseInt(next);
                flag = false;
            } else {
                System.out.println("输入的内容不是数数字,请重新输入:");
            }
        }
        return num;
    }
}
