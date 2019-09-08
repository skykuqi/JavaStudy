package IO常用类库.输入与输出支持;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */

class PrintUtil implements AutoCloseable {    //实现一些常用数据的山输出
    private OutputStream output;        //不管如何进行输出操作,核心就是OutputStream

    public PrintUtil(OutputStream output) {
        this.output = output;
    }

    public void print(long num) throws IOException {
        this.print(String.valueOf(num));
    }

    public void print(String str) throws IOException {      //输出字符串
        this.output.write(str.getBytes());
    }

    public void println(long num) throws IOException {
        this.println(String.valueOf(num));
    }

    public void println(String str) throws IOException {
        this.print(str + "\r\n");
    }

    @Override
    public void close() throws Exception {
        output.close();
    }
}

public class Demo {
    public static void main(String[] args) throws Exception {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        PrintUtil printUtil = new PrintUtil(new FileOutputStream(file));
        printUtil.println("第一次输出: 你好");
        printUtil.println("第二此输出: 你也好");
        printUtil.print(",你喜欢写代码吗?");
        printUtil.print(123456);
        printUtil.close();
    }
}
