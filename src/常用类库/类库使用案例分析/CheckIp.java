package 常用类库.类库使用案例分析;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Check {
    public static boolean checkIP(String ip) {
        if (ip == null || "".equals(ip)) {
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]?\\.){3}([12]?[0-9]?[0-9])";
        if (ip.matches(regex)) {
            String result[] = ip.split("\\.");       //拆分数组
            for (int i = 0; i < result.length; i++) {
                int temp = Integer.parseInt(result[i]);
                if (temp < 255) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

public class CheckIp {
    public static void main(String[] args) {
        /*编写正则表达式,来判定给定的IP地址是否合法*/
        //IP地址的组成就是数字,对于数字的组成有一个基础的要求,第一位的内容只能是无,1,2,后面的内容是0-9
        //第三位的内容0-9
        String str = "192.255.10.142";
        System.out.println(Check.checkIP(str));
    }
}
