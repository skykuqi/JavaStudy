package 常用类库.Date以及SimpleDateFormat类;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyDate {
    public static void main(String[] args) throws ParseException {
        double num = 4984984;
        String format = NumberFormat.getInstance().format(num);
        System.out.println(format);
    }
}
