package 常用类库.类库使用案例分析;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class SplitHtmlDemo {
    public static void main(String[] args) {
        /*对html代码进行拆分*/
        String html = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">\n";
        String regex = "\\w+=\"[a-zA-Z0-9,+]+\"";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(html);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
