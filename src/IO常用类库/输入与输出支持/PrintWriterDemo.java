package IO常用类库.输入与输出支持;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
        String name = "张三";
        int age = 75;
        double money = 45612.5236856;
        printWriter.printf("姓名:%s,年龄:%d,收入:%9.2f", name, age, money);
        printWriter.close();
        System.out.println();
    }
}
