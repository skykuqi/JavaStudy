package 网络编程;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class SocketDemo {
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 9999);   //定义服务端的连接信息
        //现在的客户端需要有输入和输出支持,所以依然要准备出Scanner与PrintWriter
        Scanner scanner = new Scanner(client.getInputStream());     //从服务器端输入内容
        scanner.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream()); //向服务器端发送内容
        boolean flag = true;
        while (flag) {
            String input = getString("请输入要发送的内容:").trim();
            out.println(input);       //加换行
            if (scanner.hasNext()) {      //服务器端有回应了
                System.out.println(scanner.next());
            }
            if ("byebye".equalsIgnoreCase(input)) {
                flag = false;
            }
        }
        scanner.close();
        out.close();
        client.close();

    }

    public static String getString(String prompt) throws IOException {
        System.out.println(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str + "\n";
    }
}
