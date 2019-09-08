package IO常用类库.File类的使用;

import java.io.File;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class ListAllFileDemo {
    public static void main(String[] args) {
        //设置任意一个目录的路径,而后将这个目录中所有文件的信息都进行打印输出处理
        //可以采用递归的方法来实现
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        File file = new File(dir);
        if (!file.isDirectory()) {
            System.out.println("当前输入的路径并不是一个文件夹路径");
        } else {
            listDir(file, 1);
        }
    }

    /**
     * 列出当前输入文件目录的所有文件列表
     *
     * @param file  当前的文件夹路径
     * @param index 请输入1
     */
    public static void listDir(File file, int index) {
        File thisFile = file;       //当前的文件路径
        StringBuilder tab = new StringBuilder();      //间隔处理符
        File[] files = thisFile.listFiles();
        for (int i = 0; i < index - 1; i++) {
            tab.append(" ");
        }
        for (File f : files) {
            System.out.println(tab.toString() + f);
            if (f.isDirectory()) {
                listDir(f, index++);
            }
        }
    }
}
