package 常用类库.类库使用案例分析.国际化应用;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class JavaApiDemo {
    public static void main(String[] args) {
        /*编写程序,实现国际化应用,从命令行输入国家的代码,例如1表示中国,2表示美国,然后进行资源文件的信息显示*/
        //本程序的实现需要通过Locale类的独享来指定区域,通过ResourceBundle类加载资源文件
        //继而使用初始化参数形式来完成
        //继续使用test包中的资源文件进行模拟
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ResourceBundle bundle = null;
        switch (i) {
            case 1:
                bundle = ResourceBundle.getBundle("test.Messages", Locale.CHINA);
                break;
            case 2:
                bundle = ResourceBundle.getBundle("test.Messages", Locale.US);
                break;
            default:
                break;
        }
        if(bundle != null){
            System.out.println(bundle.getString("welcome"));
        }
    }
}
