package 网络编程.echo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("服务器等待客户端连接中.....");
        Socket client = server.accept();            //接收客户端发送的消息
        Scanner scanner = new Scanner(client.getInputStream());
        scanner.useDelimiter("\n");       //指定回车为输入终止符号
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            if (scanner.hasNext()) {
                String str = scanner.next().trim();
                if ("byebye".equalsIgnoreCase(str)) {
                    System.out.println("ByeByeBye....");
                    flag = false;
                } else {
                    out.println("[echo] " + str);
                }
            }
        }
        out.close();
        scanner.close();
        client.close();
        server.close();
    }
}
