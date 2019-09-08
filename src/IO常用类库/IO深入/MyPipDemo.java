package IO常用类库.IO深入;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class SendThread implements Runnable {
    private PipedOutputStream output;       //管道的输出流

    public SendThread(PipedOutputStream output) {
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {   //利用管道实现数据的发送处理
                this.output.write(("信息发送: " + "第" + (i + 1) + "条消息\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutput() {
        return output;
    }
}

class ReceiveThread implements Runnable {
    private PipedInputStream input;     //管道的输入流

    public ReceiveThread(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        int len = 0;
        OutputStream output = new ByteArrayOutputStream();  //所有的数据保存到内存输出流

        try {
            while ((len = this.input.read(data)) != -1) {
                output.write(data, 0, len);
            }
            System.out.println("接收数据: " + "{" + output.toString() + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PipedInputStream getInput() {
        return input;
    }
}

public class MyPipDemo {
    public static void main(String[] args) throws IOException {
        SendThread sendThread = new SendThread(new PipedOutputStream());
        ReceiveThread receiveThread = new ReceiveThread(new PipedInputStream());
        sendThread.getOutput().connect(receiveThread.getInput());   //进行管道连接
        new Thread(sendThread, "消息发送线程").start();
        new Thread(receiveThread, "消息接收线程").start();

    }
}
