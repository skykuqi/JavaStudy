package 常用类库.类库使用案例分析;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Validator {        //定义一个专门的验证程序类
    private Validator() {
    }

    public static boolean isEmail(String email) {
        if (email == null || "".equals(email)) {      //数据为空
            return false;
        }
        String regex = "\\w+@\\w+\\.\\w+";
        return email.matches(regex);
    }
}

public class CheckEmailDemo {
    public static void main(String[] args) {
        if (args.length != 1) {   //输入有一个参数
            System.out.println("程序执行错误,没有输入初始化参数,正确格式为:java CheckEmailDemo email地址");
            System.exit(1);     //系统退出
        }
        /*输入一个E买了地址,然后使用正则表达式验证该Email地址是否正确*/
        String email = args[0];
        if (Validator.isEmail(email)) {
            System.out.println("输入的email地址正确");
        } else {
            System.out.println("输入的email地址错误");
        }
    }
}
