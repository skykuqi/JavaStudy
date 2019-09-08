package IO常用类库.File类的使用;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class MathUtil {
    private MathUtil() {
    }

    /**
     * 实现四舍五入操作
     *
     * @param num   当前的数字信息
     * @param scale 要保留的小数位数
     * @return 四舍五入的结果
     */
    public static double round(double num, int scale) {
        return Math.round(Math.pow(10, scale) * num) / Math.pow(10, scale);
    }
}

public class MyFileTest {
    public static void main(String[] args) {
        //文件是否可读:boolean canRead()
        //文件是否可写:boolean canWrite()
        File file = new File("d:" + File.separator + "java_test" + File.separator + "my.png");
        System.out.println("文件是否可读: " + file.canRead());
        System.out.println("文件是否可写: " + file.canWrite());
        //获取文件的长度long length() 即获取文件大小
        System.out.println("文件大小: " + MathUtil.round(file.length() / (double) 1024 / 1024, 2) + "Mb");
        //获取文件的最后一次修改的日期时间 long lastModified()
        System.out.println("最后的修改时间: " +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").format(new Date(file.lastModified())));
        //查看该文件是否为目录boolean isDirectory()
        //查看该文件是否为文件boolean isFile()
        System.out.println("查看是否为目录: " + file.isDirectory());
        System.out.println("查看是否为文件: " + file.isFile());

        //我们发现既然可以判断还是否为目录,那么是否可以在判断是目录之后返回该目录下的所有子目录以及目录文件呢
        System.out.println("========列出目录内容========");
        //列出目录内容 public File[] listFiles();
        File directory = new File("F:" + File.separator + "idea_workspace");
        if(directory.isDirectory()){        //判断当前这是一个目录
            File[] files = directory.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }
    }
}
