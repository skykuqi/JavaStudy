package IO常用类库.IO编程案例.输入数字并比较大小;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class CompareNumFactory {
    private CompareNumFactory() {
    }

    public static ICompareNumService getInstance() {
        return new CompareNumService();
    }
}
