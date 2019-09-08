package 类集合框架.集合工具类;

import java.io.*;
import java.util.Properties;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyPropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:" + File.separator + "java_test" + File.separator
                + "test.properties")));
        System.out.println(properties);
    }
}
