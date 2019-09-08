package IO常用类库.File类的使用;

import java.io.File;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyModifyFileNameDemo {
    public static void main(String[] args) {
        /*程序运行时输入目录名称,并把该目录下的所有文件名后缀修改为txt*/
        //文件的路径必须以最后一个.为止
        //如果存在后缀,则为修改,否则为追加
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目录名称:");
        renameDir(new File(scanner.next()));
    }

    public static void renameDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                renameDir(f);
            }
        } else {
            File parentFile = file.getParentFile();
            String name = file.getName();
            if (name.contains(".")) {
                name = name.substring(0, name.lastIndexOf(".")) + ".txt";
            } else {
                name = name + ".txt";
            }
            System.out.println(name);
        }
    }
}
