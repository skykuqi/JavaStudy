package 网络编程.echo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        Scanner print = new Scanner(System.in);
        print.useDelimiter("\n");
        Scanner scanner = new Scanner(client.getInputStream());
        scanner.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            System.out.println("请输入要发送的内容:");
            String str = print.next();
            out.println(str);
            if (scanner.hasNext()) {          //服务器有回应了
                System.out.println(scanner.next());
            }
            if ("byebye".equalsIgnoreCase(str)) {
                System.out.println("ByeByeBye....");
                flag = false;
            }
        }
        out.close();
        scanner.close();
        client.close();
    }
}
