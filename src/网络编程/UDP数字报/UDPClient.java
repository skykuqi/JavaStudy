package 网络编程.UDP数字报;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {        //接收数据信息
        DatagramSocket client = new DatagramSocket(9999);       //连接到9999端口
        byte[] data = new byte[1024];       //接收消息
        DatagramPacket packet = new DatagramPacket(data, data.length);       //接收数据的对象.接收数据的长度
        System.out.println("客户端等待发送的消息....");
        client.receive(packet);     //接收消息,所有的消息都在data的字节数组当中
        System.out.println("接收到的消息内容为: " + new String(data, 0, packet.getLength()));
        client.close();
    }
}
