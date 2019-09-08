package 网络编程;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);       //设置服务器的监听端口
        System.out.println("等待客户端连接............");
        boolean flag = true;        //循环标记
        while (flag) {
            Socket client = server.accept();//有客户端连接
            new Thread(new ClientThread(client)).start();
        }
        server.close();
    }
}

class ClientThread implements Runnable {
    private Socket client = null;       //描述每一个不同的客户端
    private Scanner scan;
    private PrintStream out;
    private boolean flag = true;            //循环处理标记

    public ClientThread(Socket client) throws IOException {
        this.client = client;
        scan = new Scanner(client.getInputStream());        //客户端输入流
        scan.useDelimiter("\n");
        out = new PrintStream(client.getOutputStream());    //客户端输出流
    }

    @Override
    public void run() {
        while (flag) {
            if (scan.hasNext()) {          //现在有数据发送
                String val = scan.next().trim();        //接受发送的数据
                if ("byebye".equalsIgnoreCase(val)) {
                    out.println("ByeByeBye.....");
                    flag = false;       //结束循环
                } else {
                    out.println("[ECHO]" + val);
                }
            }
        }
        out.close();
        scan.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
