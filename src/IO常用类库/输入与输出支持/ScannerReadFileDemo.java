package IO常用类库.输入与输出支持;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ScannerReadFileDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\n"); //设置读取分割符
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
