package IO常用类库.IO深入;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyCode {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        OutputStream output = new FileOutputStream(file);
        //此时为默认的处理操作,因此必然可以进行正常的显示输出操作
        /*output.write("今天天气不错".getBytes());
        output.close();*/
        //强制性设置编码,此时文件的输出将会造成乱码
        output.write("今天天气不错".getBytes(StandardCharsets.ISO_8859_1));
        output.close();
    }
}
