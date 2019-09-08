package IO常用类库.IO编程案例.输入数字并比较大小;


/**
 * @author : S K Y
 * @version :0.0.1
 */

public class CompareNumDemo {
    public static void main(String[] args) {
        /*编写程序,输入三个整数,并要求求出三个整数的最大值和最小值
         * 要求: 1.错误的时候可以重新输入*/
        ICompareNumService numService = CompareNumFactory.getInstance();
        int[] result = numService.stat(5);
        System.out.println("最大值: " + result[0] + " 最小值: " + result[1]);
    }
}
