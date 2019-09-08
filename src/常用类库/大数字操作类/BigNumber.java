package 常用类库.大数字操作类;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class BigNumber {
    public static void main(String[] args) {
        double round = round(19.6352, 2);
        System.out.println(round);
    }

    /**
     * 实现数据的四合五入操作
     * @param num   进行四舍五入操作的数字
     * @param scale 四舍五入保留的小数位数
     * @return  四舍五入后的结果
     */
    public static double round(double num,int scale){
        return new BigDecimal(num).divide(new BigDecimal(1.0),scale, RoundingMode.HALF_UP).doubleValue();
    }
}
