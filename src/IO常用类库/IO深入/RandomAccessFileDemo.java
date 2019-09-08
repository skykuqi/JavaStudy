package IO常用类库.IO深入;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");     //读写模式
        String[] names = new String[]{"zhangsan", "wangwu  ", "lisi    "};
        int[] ages = new int[]{30, 20, 16};
        for (int i = 0; i < names.length; i++) {
            accessFile.write(names[i].getBytes());      //写入字符串
            accessFile.writeInt(ages[i]);
        }
        accessFile.close();
    }
}

class ReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");     //读写模式
        //读取"wangwu  "的数据,而后回跳24位读取"zhangsan"的数据
        accessFile.skipBytes(12);       //跳过12个字节数据,每个人的信息所占的字节数(8 + 4);
        byte[] data = new byte[8];
        int len = accessFile.read(data);
        System.out.println("姓名: " + new String(data, 0, len) + "年龄: " + accessFile.readInt());
        accessFile.seek(0);        //回跳都顶点
        len = accessFile.read(data);
        System.out.println("姓名: " + new String(data, 0, len) + "年龄: " + accessFile.readInt());
    }
}

