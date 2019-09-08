package IO常用类库.输入与输出支持;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class OutAndErrorDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("d:" + File.separator + "java_test" + File.separator + "demo02.txt");
        System.setErr(new PrintStream(
                new FileOutputStream(file)));
        try {
            Integer.valueOf("a");
        }catch (Exception e){
            System.out.println(e);
            System.err.println(e);
        }
    }
}
