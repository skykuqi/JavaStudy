package IO常用类库.输入与输出支持;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ScannerDemo {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的生日:");
        if (!scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("您的输入有误");
        }else {
            String birthday = scanner.next();
            System.out.println("您的生日为: " + new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        }
        scanner.close();
    }
}
