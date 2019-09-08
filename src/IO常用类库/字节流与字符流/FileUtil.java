package IO常用类库.字节流与字符流;

import java.io.*;
import java.util.Scanner;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class FileUtil { //定义一个文件操作的工具类
    private File srcFile;       //源文件路径
    private File desFile;       //目标文件路径

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtil(String src, String des) {
        this.srcFile = new File(src);
        this.desFile = new File(des);
    }

    /**
     * 使用新的方法进行文件夹的拷贝,同时兼容了之前的单文件拷贝
     *
     * @return 拷贝结果
     */
    public boolean copyFile() throws IOException {
        if (this.srcFile.isFile()) {
            copy();     //用于兼容之前的方法
        } else { //实现多文件的拷贝
            copyFile(srcFile);
        }
        return true;
    }

    /**
     * 私有方法,进行文件夹拷贝的递归操作
     * @param nowFile 当前的文件
     * @throws IOException
     */
    private void copyFile(File nowFile) throws IOException {
        if (nowFile.isDirectory()) {
            File[] files = nowFile.listFiles(); //列出全部目录组成
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    copyFile(files[i]);
                }
            }
        } else { //当前是文件
            String replace = nowFile.getPath().replace(this.srcFile.getPath() + File.separator, desFile.getPath() + File.separator);
            File newFile = new File(replace);
            this.copyFile(nowFile, newFile);
        }
    }

    /**
     * 私有方法,拷贝文件
     * @param srcFile   当前的文件
     * @param desFile   目标文件
     * @throws IOException
     */
    private void copyFile(File srcFile, File desFile) throws IOException {
        if (!srcFile.exists()) {
            System.out.println("当前的拷贝路径不存在");
        }
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFile);
            if (!desFile.getParentFile().exists()) desFile.getParentFile().mkdirs();
            output = new FileOutputStream(desFile);
            byte data[] = new byte[1024];  //开始一个拷贝的缓冲区
            int len;
            while ((len = input.read(data)) != -1) {//拷贝文件
                output.write(data, 0, len);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     * 文件的拷贝处理
     *
     * @return 拷贝成功结果
     */
    @Deprecated     //使用注解声明该方法已经过时
    public boolean copy() throws IOException {
        if (!this.srcFile.exists()) {
            System.out.println("拷贝的源文件不存在");
            return false;       //源文件不存在,拷贝失败
        }
        if (!this.desFile.getParentFile().exists()) {
            this.desFile.getParentFile().mkdirs();      //如果不存在父目录,则开始创建父目录
        }
        byte data[] = new byte[1024];  //开始一个拷贝的缓冲区
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(this.srcFile);
            output = new FileOutputStream(this.desFile);
            int len = 0;
            while ((len = input.read(data)) != -1) {//拷贝文件
                output.write(data, 0, len);
            }
            return true;
        } catch (IOException e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}

class FileUtilTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要拷贝的文件路径:");
        String src = scanner.next();
        System.out.println("请输入目标文件路径:");
        String des = scanner.next();
        long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(new File(src), new File(des));
        System.out.println(fileUtil.copyFile() ? "文件拷贝成功" : "文件拷贝失败");
        long end = System.currentTimeMillis();
        System.out.println("拷贝用时: " + (end - start));
    }
}
