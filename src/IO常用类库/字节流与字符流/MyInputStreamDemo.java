package IO常用类库.字节流与字符流;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyInputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        InputStream inputStream = new FileInputStream(file);
        byte [] data = new byte[1024];  //开辟一个缓冲区读取数据
        int len = inputStream.read(data);//读取数据,数据全部保存在字节数组之中
        System.out.println("读取到的数据: " + new String(data,0,len));
        inputStream.close();
    }
}
