package IO常用类库.File类的使用;

import java.io.File;
import java.io.IOException;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyFileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "java_test"
                + File.separator + "java_demo" + File.separator + "demo1java.txt");
        //如果现在想要进行文件的基本操作,可以使用如下的基本方法:
        /*  1.public boolean createNewFile()throws IOException 创建新文件
        (true,文件不存在,成功创建,false,文件已经存在,创建失败)*/
        /*2.判断文件是存在: public boolean exists()*/
        /*3.public boolean delete()删除当前文件*/
        /*4.获取父路径getParentFile public File getParentFile() */
        /*5.创建目录:
         * public boolean mkdir()创建单个目录
         * public boolean mkdirs()创建多个目录*/
        if(!file.getParentFile().exists()){     //父路径不存在
            System.out.println(file.getParentFile().mkdirs()?"创建父路径成功":"创建父路径失败");      //创建父路径
        }
        System.out.println(file.createNewFile()?"创建文件成功":"创建文件失败");
    }
}
