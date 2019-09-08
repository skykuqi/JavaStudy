package 常用类库.正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class MyRegex {
    public static void main(String[] args) {
        String str = "java_12345asc@12_sad.com";
        //根据其验证email格式了
        //email的用户名可以由字母,数字,下划线所组成
        //email的域名可以由字母,数字,_所组成
        //域名必须是 .cn .com .com.cn .net .io
        //java_12345asc@12_sad.com.cn       _java_12345asc@12_sad.com   java_12345asc@12_sad.com
        String regex = "[a-zA-Z0-9]\\w+@\\w+\\.(cn|com\\.cn|net|com|io)";
        System.out.println(str.matches(regex));
    }
}
class RegexDemo{
    public static void main(String[] args) {
        String str = "dasdajionmiol()5+26+48d4aw";  //按照非字母拆分
        String regex = "[^a-zA-Z]+";
        Pattern compile = Pattern.compile(regex);   //编译正则表达式
        String[] split = compile.split(str);
        System.out.println(Arrays.toString(split));
    }
}
class MatcherDemo{
    public static void main(String[] args) {
        String str = "101";
        String regex = "\\d+";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(str);
        System.out.println(matcher.matches());
    }
}
class MatcherTest{
    public static void main(String[] args) {
        //要求取出#{内容} 标记中的所有内容
        String str = "INSERT INTO user(userName,userAge) VALUES (#{userName},#{userAge})";
        String regex = "#\\{\\w+}";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group(0) + " " + matcher.group(0).replaceAll("#\\{|}",""));
        }

    }
}