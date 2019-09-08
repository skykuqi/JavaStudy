package 常用类库.base64加密与解密;


import java.util.Base64;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class BaseUtil {        //加密的盐值与此处对外不公布
    private static final String SALT = "dasjidnas";       //公版的盐值
    private static final int REPEAT = 5;        ///加密的次数

    /**
     * 加密处理
     *
     * @param password 要加密的字符串密码数据,需要与盐值配合
     * @return 加密后的数据
     */
    public static String encode(String password) {
        password = password + "{" + SALT + "}";
        byte[] bytes = password.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            bytes = Base64.getEncoder().encode(bytes);
        }
        return new String(bytes);
    }

    /**
     * 解密
     *
     * @param needDecode 需要解密的数据
     * @return 解密的结果
     */
    public static String decode(String needDecode) {
        byte[] bytes = needDecode.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            bytes = Base64.getDecoder().decode(bytes);
        }
        return new String(bytes).replaceAll("\\{\\w+}", "");
    }
}

public class MyBase64 {
    public static void main(String[] args) {
        String password = "qwer123456";
        String encode = BaseUtil.encode(password);
        System.out.println(encode);
        System.out.println(BaseUtil.decode(encode));
    }
}
