package IO常用类库.字节流与字符流;


import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyOutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        if(!file.getParentFile().exists()){     //保证父目录存在
            file.getParentFile().mkdirs();      //创建父目录
        }
        OutputStream outputStream = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write("可以直接输入字符串");  //直接输出字符串,而且适用于中文
        writer.close();
    }
}
