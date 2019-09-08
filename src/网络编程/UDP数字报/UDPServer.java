package 网络编程.UDP数字报;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(9000);       //连接到9000端口(连接端口)
        String str = "你好,今天的天气是晴天..";
        byte[] data = str.getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length
                , InetAddress.getByName("localhost"), 9999);  //发送数据(客户端所在端口)
        server.send(packet);    //发送消息
        System.out.println("消息发送完毕...");
        server.close();
    }
}
