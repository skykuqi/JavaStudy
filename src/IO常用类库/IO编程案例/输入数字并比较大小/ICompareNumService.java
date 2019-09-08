package IO常用类库.IO编程案例.输入数字并比较大小;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public interface ICompareNumService {
    /**
     * 输入数据并且返回输入数据的最大值和最小值
     * @param count 表示要输入数据的个数
     * @return  包含有两个内容,第一个是最大值,第二个是最小值
     */
    public int[] stat(int count);
}
