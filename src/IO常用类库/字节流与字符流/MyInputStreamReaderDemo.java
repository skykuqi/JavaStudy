package IO常用类库.字节流与字符流;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyInputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();     //创建父目录
        }
        try (OutputStream output = new FileOutputStream(file,true)) {
            String str = "www.baidu.com\r\n";       //准备要输出的内容
            output.write(str.getBytes());       //将字符串改变为字节数组
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
