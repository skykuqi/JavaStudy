package IO常用类库.字节流与字符流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo01.txt");
        if(!file.getParentFile().exists()){     //保证父目录存在
            file.getParentFile().mkdirs();      //创建父目录
        }
        Writer writer = new FileWriter(file);
        String str = "要输出的内容";
        writer.write(str);
        writer.append("\r\n追加输出内容");
        writer.close();
    }
}
