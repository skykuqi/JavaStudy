package 常用类库.类库使用案例分析;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        /*定义一个StringBuffer类对象,然后通过append()方法向对象中添加26个小写字符,要求每次只添加一次,同添加26次,
        然后按照逆序的方式输出,并且可以删除前5个字符*/
        /*本操作主要是训练StringBuffer类中的处理方法,因为StringBuffer的主要特点是允许修改*/
        StringBuffer buffer = new StringBuffer();
        for (int i = 'a'; i <= 'z'; i++) {
            buffer.append((char) i);        //保存字符
        }
        buffer.reverse().delete(0, 5);
        System.out.println(buffer.toString());
    }
}
