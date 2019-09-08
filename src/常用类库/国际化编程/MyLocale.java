package 常用类库.国际化编程;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyLocale {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "us");    //表示英文环境
        System.out.println(locale);
        System.out.println(Locale.getDefault());
        System.out.println(Locale.CHINA + " " + Locale.US);
    }
}

class MyResourceBundle {
    public static void main(String[] args) {
        ResourceBundle message = ResourceBundle.getBundle("message");
        System.out.println(message.getString("welcome"));
    }
}

class LocaleTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("test.Messages");
        System.out.println(bundle.getString("welcome"));
    }
}
class LocaleUSTest{
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("test.Messages",Locale.UK);
        System.out.println(bundle.getString("welcome"));
    }
}
class MyMessageFormatDemo{
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("test.Messages");
        String welcome = bundle.getString("welcome");
        String format = MessageFormat.format(welcome, "\n国际化模拟程序\n");
        System.out.println(format);
    }
}
