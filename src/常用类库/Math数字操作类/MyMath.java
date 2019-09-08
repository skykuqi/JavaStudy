package 常用类库.Math数字操作类;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class MathUtil{
    private MathUtil(){}      //私有方法,无法实例化

    /**
     * 实现数据的四合五入操作
     * @param num   进行四舍五入操作的数字
     * @param scale 四舍五入保留的小数位数
     * @return  四舍五入后的结果
     */
    public static double round(double num,int scale){
        return Math.round(num * Math.pow(10,scale)) / Math.pow(10,scale);
    }
}
public class MyMath {
    public static void main(String[] args) {
        System.out.println(MathUtil.round(12.25968,4));
    }
}
