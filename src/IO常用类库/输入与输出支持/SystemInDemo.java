package IO常用类库.输入与输出支持;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;      //此时的输入流为键盘输入
        System.out.println("请输入信息:");
        byte[] data = new byte[1024];
        int len = input.read(data);
        System.out.println("输入内容为: " + new String(data,0,len));
    }
}
