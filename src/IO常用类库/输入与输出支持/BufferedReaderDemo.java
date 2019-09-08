package IO常用类库.输入与输出支持;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您的年龄:");
        String msg = "";      //接收输入信息
        while (!(msg = input.readLine()).matches("\\d+")) {
            System.out.println("您输入的数据有误,请重新输入: ");
        }
        System.out.println("输入的年龄为: " + msg);
    }
}
