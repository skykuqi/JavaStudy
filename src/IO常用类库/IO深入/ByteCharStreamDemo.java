package IO常用类库.IO深入;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ByteCharStreamDemo {
    public static void main(String[] args) throws IOException {
        String str = "www.baidu.com";
        InputStream input = new ByteArrayInputStream(str.getBytes());   //将数据保存到内存流
        ByteArrayOutputStream output = new ByteArrayOutputStream();  //读取内存中的数据
        int data = 0;
        while ((data = input.read()) != -1) {    //每次只读取一个字节
            output.write(Character.toUpperCase((char) data));       //向输出流保存数据
        }
        //在ByteArrayOutputStream类中有一个重要的方法获取全部保存在内存中的数据流信息:
        //    public synchronized byte toByteArray()[]
        //    public synchronized String toString()
        byte[] result = output.toByteArray();       //获取全部数据
        System.out.println(new String(result));
        output.close();
    }
}
