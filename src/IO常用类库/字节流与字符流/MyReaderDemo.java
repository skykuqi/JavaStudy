package IO常用类库.字节流与字符流;


import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        if (file.exists()) {
            Reader reader = new FileReader(file);
            char data[] = new char[1024];
            int len = reader.read(data);
            System.out.println("读取到的内容: " + new String(data, 0, len));
            reader.close();
        }
    }
}
